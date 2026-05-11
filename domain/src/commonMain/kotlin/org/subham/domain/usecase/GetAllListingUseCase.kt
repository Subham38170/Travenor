package org.subham.domain.usecase

import org.subham.domain.model.TravelListing
import org.subham.domain.repository.ListingRepository

class GetAllListingUseCase(
    private val repository: ListingRepository
) {
    suspend fun execute(): List<TravelListing> {
        val data = repository.getAllListings()

        return if (data.isSuccess) data.getOrNull()!! else emptyList<TravelListing>()
    }

}