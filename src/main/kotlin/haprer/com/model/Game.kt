package haprer.com.model

import io.ktor.websocket.*

object Game {

    const val MAX_PLAYERS = 100

    private val field: Array<Array<Int>> = Array(1000) {
        Array(1000) {0};
    };

    private var sockets: HashSet<WebSocketSession> = HashSet();

    fun addSocket(socket: WebSocketSession): Unit {
        if (sockets.size >= MAX_PLAYERS) return;
        this.sockets.add(socket);
    }

    fun removeSocket(socket: WebSocketSession): Unit {
        sockets.remove(socket);
    }
}