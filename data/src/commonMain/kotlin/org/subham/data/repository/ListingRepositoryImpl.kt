package org.subham.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.subham.data.datasource.RemoteDataSource
import org.subham.data.mappers.TravelListingMapper
import org.subham.domain.model.TravelListing
import org.subham.domain.repository.ListingRepository

class ListingRepositoryImpl(
    private val dataSource: RemoteDataSource
): ListingRepository {
    override suspend fun getAllListings(): Result<List<TravelListing>> {
        return try{

            val response = dataSource.getAllListings()
            if (response.isSuccess) {
                val listings = response.getOrNull()!!
                val models = TravelListingMapper.toDomain(listings)
                Result.success(models)
            }
            else{
                Result.failure(Exception("Something went wrong ${response.exceptionOrNull()}"))
            }
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun getListingById(id: String): Result<TravelListing> {
        return try {

            val response = dataSource.getListingById(id)
            if(response.isSuccess){
                val listing = response.getOrNull()!!
                val model = TravelListingMapper.toDomain(listing)
                Result.success(model)
            }
            else{
                Result.failure(Exception("Something went wrong ${response.exceptionOrNull()}"))
            }
        }catch (e: Exception){
            Result.failure(e)
        }
    }


}