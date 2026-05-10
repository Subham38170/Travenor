package org.subham.data.model

import kotlinx.serialization.Serializable


@Serializable
data class SignInResponse(
    val token: String,
    val user: UserDto
)
