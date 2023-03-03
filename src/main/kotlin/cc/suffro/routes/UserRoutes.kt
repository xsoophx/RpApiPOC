package cc.suffro.routes

import cc.suffro.VERSION
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

const val USER = "user"

fun Route.getUserById() {
    get("/$VERSION/$USER/{id}") {
        call.respondText("Hello User!")
    }
}

fun Route.createUserById() {
    post("/$VERSION/$USER/{id}") {
    }
}

fun Route.deleteUserById() {
    delete("/$VERSION/$USER/{id}") {
    }
}

fun Application.userRoutes() {
    routing {
        getUserById()
        createUserById()
        deleteUserById()
    }
}

