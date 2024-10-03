package haprer.com.model

import io.ktor.websocket.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*

object Game {

    const val SOCKET_UPDATE_RATE_MS: Long = 500; //how often state updates are broadcast to the clients
    const val MAX_PLAYERS = 100

    //for updating the clients
    private var sockets: MutableList<WebSocketSession> = Collections.synchronizedList(mutableListOf())
    val socketsLock = Mutex(false);  //synchronize access to the sockets hashset
    var sockUpdateJob: Job? = null

    private val field: Array<Array<Int>> = Array(500) {
        Array(500) {0};
    }

    init {
        //for testing purposes TODO: remove
        field[200][200] = 1;
    }



    suspend fun addSocket(socket: WebSocketSession): Unit {
        socketsLock.withLock {
            if (sockets.size >= MAX_PLAYERS) return;
            this.sockets.add(socket);
            if (sockets.size == 1) { //start the update coroutine
                coroutineScope {
                    sockUpdateJob = launch {
                        while(true) {
                            //TODO synchronize access to the field
                            val fieldList = field.map { it.toList() }
                            val jsonString = Json.encodeToString(fieldList)
                            socketsLock.withLock {
                                for (sock: WebSocketSession in sockets) {
                                    sock.send(jsonString)
                                }
                            }
                            delay(timeMillis = SOCKET_UPDATE_RATE_MS);
                        }
                    }
                }
            }
        }
    }

    /**
     * takes a socket out of the list held by the game, meaning it will no longer be sent updates
     * @param socket: the socket to be removed
     */
    suspend fun removeSocket(socket: WebSocketSession): Unit {
        socketsLock.withLock {
            sockets.remove(socket);
            if (sockets.size <= 0) {
                //Cancel the sockUpdates, because currently no one is connected.
                this.sockUpdateJob?.cancel();
            }
        }
    }
}