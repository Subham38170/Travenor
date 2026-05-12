package org.subham.presentation.feature.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.subham.domain.usecase.SignInUseCase
import org.subham.presentation.feature.signup.AuthNavigation

class SignInViewModel(
    private val loginUseCase: SignInUseCase
) : ViewModel() {

    private val _navigationState = MutableSharedFlow<AuthNavigation>()
    val navigationState = _navigationState.asSharedFlow()

    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState = _uiState.asStateFlow()


    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()


    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    fun onEmailChange(newEmail: String) = _email.update { newEmail }
    fun onPasswordChange(newPassword: String) = _password.update { newPassword }


    fun signIn() {
        viewModelScope.launch {
            val result = loginUseCase.execute(email.value, password.value)
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

    fun onSignUpClick(){
        viewModelScope.launch {
            _navigationState.emit(AuthNavigation.ToSignUp)
        }
    }


}