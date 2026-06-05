package org.subham.domain.usecase

import org.subham.domain.model.TravelListing
import org.subham.domain.repository.ListingRepository

class GetListingByIdUseCase(
    private val listingRepository: ListingRepository
) {
    suspend fun execute(id: String): Result<TravelListing> = listingRepository.getListingById(id)
}