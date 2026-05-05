package org.subham.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.subham.domain.model.TravelListing
import org.subham.domain.repository.ListingRepository

class GetAllListingUseCase(
    private val repository: ListingRepository
) {
    fun execute(): Flow<List<TravelListing>> {
        val data = repository.getAllListings()

        data.map {
            it.sortedByDescending { listing -> listing.rating }
        }
        return data
    }

}