package cc.suffro.data

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val password: String,
)