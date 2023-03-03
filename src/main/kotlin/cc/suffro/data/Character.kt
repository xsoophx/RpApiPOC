package cc.suffro.data

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val name: String,
    val user: User,
)
