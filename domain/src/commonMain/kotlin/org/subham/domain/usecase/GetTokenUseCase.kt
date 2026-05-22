package org.subham.domain.usecase

import org.subham.domain.repository.CacheRepository
import org.subham.domain.repository.ListingRepository

class GetTokenUseCase(
    private val repository: CacheRepository
) {

    suspend fun execute(): String? = repository.getAuthToken()
}