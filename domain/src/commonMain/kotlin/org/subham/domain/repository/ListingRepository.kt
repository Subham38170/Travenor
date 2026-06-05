package org.subham.domain.repository

import kotlinx.coroutines.flow.Flow
import org.subham.domain.model.TravelListing

interface ListingRepository {

    suspend fun getAllListings(): Result<List<TravelListing>>

    suspend fun getListingById(id: String) : Result<TravelListing>
}