package org.subham.domain.repository

import kotlinx.coroutines.flow.Flow
import org.subham.domain.model.TravelListing

interface ListingRepository {

    fun getAllListings(): Flow<List<TravelListing>>
    fun getListingById(): Flow<TravelListing>
}