package cc.suffro.user.routes

import cc.suffro.VERSION
import cc.suffro.user.Database.userService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import java.lang.NumberFormatException
import mu.KotlinLogging

const val USER = "user"
val logger = KotlinLogging.logger {}

fun Route.getUserById() {
    get("/$VERSION/$USER/{id}") {
        val id = call.parseOrThrow("Invalid ID. ID has to be of type Integer.")
        val user = id?.let { userService.read(it) }

        user?.let {
            call.respond(HttpStatusCode.OK, user)
        } ?: call.respond(HttpStatusCode.NotFound)

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

fun Route.updateUserById() {
    put("/$VERSION/$USER/{id}") {

    }
}

suspend fun ApplicationCall.parseOrThrow(message: String): Int? {
    val id = try {
        this.parameters["id"]?.toInt()
    } catch (e: NumberFormatException) {
        this.respond(HttpStatusCode.BadRequest, message)
        logger.error { message }
        null
    }
    return id
}
