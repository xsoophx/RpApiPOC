package cc.suffro.user.data

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val password: String,
)
