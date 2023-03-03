package cc.suffro.character.data

import cc.suffro.user.data.User
import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val name: String,
    val user: User,
)
