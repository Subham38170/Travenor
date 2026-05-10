package org.subham.domain.usecase

import org.subham.domain.model.UserModel
import org.subham.domain.repository.UserRepository

class SignInUseCase(
    private val repository: UserRepository
) {
    suspend fun execute(
        email: String,
        password: String
    ): Result<UserModel> {
        return repository.login(email, password)

    }
}