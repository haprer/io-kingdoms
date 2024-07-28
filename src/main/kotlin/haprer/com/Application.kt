package haprer.com

import haprer.com.plugins.*
import haprer.com.plugins.configureMonitoring
import haprer.com.plugins.configureRouting
import haprer.com.plugins.configureSerialization
import haprer.com.plugins.configureSockets
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSockets()
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
