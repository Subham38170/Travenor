package org.subham.data.repository

import org.subham.data.datasource.CacheDataSource
import org.subham.domain.repository.CacheRepository

class CacheRepositoryImpl(
    private val cacheDataSource: CacheDataSource
) : CacheRepository {
    override suspend fun getAuthToken(): String? {
        return cacheDataSource.getAuthToken()
    }
}