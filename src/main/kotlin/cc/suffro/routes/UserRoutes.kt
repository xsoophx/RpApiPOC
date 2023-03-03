package cc.suffro.routes

import cc.suffro.VERSION
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

const val USER = "user"
fun Application.configureUserRoutes() {
    routing {
        route("/$VERSION/$USER/{id}") {
            get {
                call.respondText("Hello User!")
            }

            post {

            }
        }
    }
}
