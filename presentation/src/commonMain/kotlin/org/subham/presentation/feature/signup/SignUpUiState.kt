package org.subham.presentation.feature.signup

import org.subham.domain.model.UserModel

data class SignUpUiState(
    val user: UserModel? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)