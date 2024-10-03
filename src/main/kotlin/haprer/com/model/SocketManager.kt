package haprer.com.model

import io.ktor.websocket.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex


/**
 * This class is to compartmentalize all of the socket access from the Game to simplify
 * thread safety --currently not in use
 */
class SocketManager {
//
//    private val sessionMutex = Mutex()
//    private val sockets: MutableList<WebSocketSession> = mutableListOf()
//
//
//    suspend fun addSocket(socket: WebSocketSession): Unit {
//        if (sockets.size >= MAX_PLAYERS) return;
//        this.sockets.add(socket);
//        }
//    }
}