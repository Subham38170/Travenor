package org.subham.domain.repository

import org.subham.domain.model.RegisterModel
import org.subham.domain.model.UserModel

interface UserRepository {

    suspend fun login(
        email: String,
        password: String
    ): Result<UserModel>


    suspend fun signup(
        request: RegisterModel
    ): Result<UserModel>
}