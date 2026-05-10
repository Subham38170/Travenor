package org.subham.presentation.feature.signin

import org.subham.domain.model.UserModel

data class SignInUiState(
    val user: UserModel? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)