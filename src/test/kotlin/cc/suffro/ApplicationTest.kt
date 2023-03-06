package cc.suffro

import cc.suffro.user.configureUser
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureUser()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}
