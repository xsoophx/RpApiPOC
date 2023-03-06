package cc.suffro.user.routes

import cc.suffro.VERSION
import cc.suffro.user.services.UserService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import mu.KotlinLogging

const val USER = "user"
val logger = KotlinLogging.logger {}

fun Route.getUserById(userService: UserService) {
    get("/$VERSION/$USER/{id}") {
        val id = call.parseIntElseError("Invalid ID. ID has to be of type Integer.")
        val user = id?.let { userService.read(it) }

        user?.let {
            call.respond(HttpStatusCode.OK, user)
        } ?: call.respond(HttpStatusCode.NotFound)
    }
}

fun Route.createUserById(userService: UserService) {
    post("/$VERSION/$USER/{id}") {
    }
}

fun Route.deleteUserById(userService: UserService) {
    delete("/$VERSION/$USER/{id}") {
    }
}

fun Route.updateUserById(userService: UserService) {
    put("/$VERSION/$USER/{id}") {
    }
}

suspend fun ApplicationCall.parseIntElseError(message: String): Int? {
    val id = this.parameters["id"]?.toIntOrNull()

    if (id == null) {
        this.respond(HttpStatusCode.BadRequest, message)
        logger.error { message }
    }

    return id
}
