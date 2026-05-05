package org.subham.data.mappers

import org.subham.data.model.TravelListingDto
import org.subham.domain.model.TravelListing

object TravelListingMapper {


    fun toDomain(dto: TravelListingDto): TravelListing {
        return TravelListing(
            id = dto.id,
            description = dto.description,
            title = dto.title,
            rating = dto.rating,
            hostName = dto.hostName,
            imageUrl = dto.imageUrl,
            location = dto.location,
            amenities = dto.amenities,
            isFavorite = dto.isFavorite,
            pricePerNight = dto.pricePerNight
        )

    }

    fun toDomain(dtos: List<TravelListingDto>): List<TravelListing> = dtos.map { toDomain(it) }


    fun toDto(domain: TravelListing): TravelListingDto{
        return TravelListingDto(
            id = domain.id,
            description = domain.description,
            title = domain.title,
            rating = domain.rating,
            hostName = domain.hostName,
            imageUrl = domain.imageUrl,
            location = domain.location,
            amenities = domain.amenities,
            isFavorite = domain.isFavorite,
            pricePerNight = domain.pricePerNight
        )

    }

    fun toDto(domains: List<TravelListing>): List<TravelListingDto> = domains.map { toDto(it) }
}
