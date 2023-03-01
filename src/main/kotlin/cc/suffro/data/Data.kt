package cc.suffro.data

data class User(
    val name: String,
    val password: String,
)

data class World(
    val name: String,
)

data class Character(
    val name: String,
    val user: User,
)
