package cc.suffro.user.tables

import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", length = 50)
    val password = varchar("password", length = 50)

    override val primaryKey = PrimaryKey(id)
}
