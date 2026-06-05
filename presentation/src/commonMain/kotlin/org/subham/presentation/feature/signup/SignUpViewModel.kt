package org.subham.presentation.feature.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.subham.domain.model.RegisterModel
import org.subham.domain.usecase.RegisterUseCase
import org.subham.presentation.feature.signin.SignInUiState

class SignUpViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _navigationState = MutableSharedFlow<AuthNavigation>()
    val navigationState = _navigationState.asSharedFlow()

    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState = _uiState.asStateFlow()


    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()


    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword = _confirmPassword.asStateFlow()


    fun onEmailChange(newEmail: String) = _email.update { newEmail }
    fun onPasswordChange(newPassword: String) = _password.update { newPassword }
    fun onNameChange(newName: String) = _name.update { newName }
    fun onConfirmPasswordChange(newPassword: String) = _confirmPassword.update { newPassword }

    fun signUp() {
        viewModelScope.launch(Dispatchers.IO){
            if (confirmPassword.value != password.value) {
                _uiState.update {
                    it.copy(
                        errorMessage = "Password and Confirm Password do not match"
                    )
                }
                return@launch
            }
            val result = registerUseCase.execute(
                RegisterModel(
                    email = email.value,
                    password = password.value,
                    firstName = name.value,
                )
            )
            result.onSuccess { user ->
                _uiState.update {
                    it.copy(
                        user = user,
                        isLoading = false
                    )
                }
                _navigationState.emit(AuthNavigation.ToListing)
            }.onFailure { e ->
                _uiState.update {
                    it.copy(
                        errorMessage = e.message,
                        isLoading = false

                    )
                }
            }
        }
    }

    fun onSignInClick() {
        viewModelScope.launch {
            _navigationState.emit(AuthNavigation.ToLogin)
        }
    }
}