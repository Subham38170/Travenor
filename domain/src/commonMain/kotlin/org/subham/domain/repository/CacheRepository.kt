package org.subham.domain.repository

interface CacheRepository {

    suspend fun getAuthToken(): String?

}