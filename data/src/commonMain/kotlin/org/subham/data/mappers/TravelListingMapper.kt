package org.subham.data.mappers

import org.subham.data.model.TravelListingDto
import org.subham.data.model.TravelListingResponse
import org.subham.data.model.TripDateDto
import org.subham.domain.model.TravelListing
import org.subham.domain.model.TripDate

object TravelListingMapper {


    fun toDomain(dto: TravelListingDto): TravelListing {
        return TravelListing(
            id = dto.id,
            title = dto.title,
            rating = dto.rating,
            images = dto.images,
            location = dto.location,
            amenities = dto.amenities,
            availableFrom = dto.availableFrom,
            availableTo = dto.availableTo,
            capacity = dto.capacity,
            category = dto.category,
            city = dto.city,
            country = dto.country,
            currency = dto.currency,
            description = dto.description,
            isActive = dto.isActive,
            price = dto.price,
            reviewCount = dto.reviewCount,
            tripDates = toDomain(dto.tripDates),
            vendorId = dto.vendorId
        )

    }

    fun toDomain(dtos: TravelListingResponse): List<TravelListing> =
        dtos.listings!!.map { toDomain(it!!) }

    fun toDomain(tripDate: TripDateDto): TripDate {
        return TripDate(
            availableSpots = tripDate.availableSpots,
            createdAt = tripDate.createdAt,
            currentBookings = tripDate.currentBookings,
            endDate = tripDate.endDate,
            id = tripDate.id,
            isActive = tripDate.isActive,
            listingId = tripDate.listingId,
            maxCapacity = tripDate.maxCapacity,
            startDate = tripDate.startDate,
            updatedAt = tripDate.updatedAt
        )

    }

    fun toDomain(tripDates: List<TripDateDto?>?): List<TripDate> =
        tripDates?.mapNotNull { it?.let { toDomain(it) } } ?: emptyList()

}
