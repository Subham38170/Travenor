package org.subham.data.mappers

import org.subham.data.model.TravelListingDto
import org.subham.data.model.TravelListingResponse
import org.subham.domain.model.TravelListing

object TravelListingMapper {


    fun toDomain(dto: TravelListingDto): TravelListing {
        return TravelListing(
            id = dto.id,
            title = dto.title,
            rating = dto.rating,
            images = dto.images,
            location = dto.location

        )

    }

    fun toDomain(dtos: TravelListingResponse): List<TravelListing> = dtos.listings!!.map { toDomain(it!!) }


}
