package cc.suffro.user

import cc.suffro.user.routes.createUserById
import cc.suffro.user.routes.deleteUserById
import cc.suffro.user.routes.getUserById
import cc.suffro.user.routes.updateUserById
import cc.suffro.user.services.UserService
import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import org.jetbrains.exposed.sql.Database

fun Application.configureUser() {
    val database = Database.connect(
        url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
        user = "root",
        driver = "org.h2.Driver",
        password = "",
    )
    val userService = UserService(database)

    routing {
        getUserById(userService)
        createUserById(userService)
        deleteUserById(userService)
        updateUserById(userService)
    }
}
