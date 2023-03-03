package cc.suffro

import cc.suffro.plugins.configureDatabases
import cc.suffro.plugins.configureSerialization
import cc.suffro.routes.userRoutes
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

const val VERSION = "v1"
const val PORT = 8080
const val HOST = "0.0.0.0"

fun main() {
    embeddedServer(Netty, port = PORT, host = HOST, module = Application::rpgModule)
        .start(wait = true)
}

private fun Application.rpgModule() {
    configureSerialization()
    configureDatabases()

    userRoutes()
}
