package org.subham.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.subham.data.datasource.DummyDataSource
import org.subham.data.mappers.TravelListingMapper
import org.subham.domain.model.TravelListing
import org.subham.domain.repository.ListingRepository

class ListingRepositoryImpl(
    private val datasource: DummyDataSource
): ListingRepository {
    override fun getAllListings(): Flow<List<TravelListing>> {
        return datasource.listings.map {
            TravelListingMapper.toDomain(it)
        }
    }

    override fun getListingById(): Flow<TravelListing> {
        TODO("Not yet implemented")
    }
}