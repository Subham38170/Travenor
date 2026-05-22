package org.subham.data.repository

import org.subham.data.datasource.CacheDataSource
import org.subham.data.datasource.RemoteDataSource
import org.subham.data.mappers.RegisterRequestMapper
import org.subham.data.mappers.UserMapper
import org.subham.data.model.request.SignInRequest
import org.subham.domain.model.RegisterModel
import org.subham.domain.model.UserModel
import org.subham.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val cacheDataSource: CacheDataSource
) : UserRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Result<UserModel> {
        return try {

            val response = remoteDataSource.signIn(SignInRequest(email, password))

            if (response.isSuccess) {
                val userDto = response.getOrNull()!!
                val userModel = UserMapper.toDomain(userDto.user)
                cacheDataSource.saveAuthToken(userDto.token)
                Result.success(userModel)
            } else {
                Result.failure(Exception("Login failed with status code : ${response.exceptionOrNull()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signup(request: RegisterModel): Result<UserModel> {
        return try {
            val response = remoteDataSource.register(RegisterRequestMapper.toDto(request))
            if(response.isSuccess){
                val userDto = response.getOrNull()!!
                val userModel = UserMapper.toDomain(userDto.user)
                cacheDataSource.saveAuthToken(userDto.token)
                Result.success(userModel)

            }
            else{
                Result.failure(Exception("SignUp failed with status code : ${response.exceptionOrNull()}"))

            }
        }catch (e: Exception){
            Result.failure(e)
        }
    }


}