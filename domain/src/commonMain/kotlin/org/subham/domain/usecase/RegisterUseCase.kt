package org.subham.domain.usecase

import org.subham.domain.model.RegisterModel
import org.subham.domain.model.UserModel
import org.subham.domain.repository.UserRepository

class RegisterUseCase(
    private val repository: UserRepository
) {
    suspend fun execute(
        request: RegisterModel
    ): Result<UserModel> = repository.signup(request)
}