package org.subham.data.model.request

import kotlinx.serialization.Serializable


@Serializable
data class SignInRequest(
    val email: String,
    val password: String
)