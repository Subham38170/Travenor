package org.subham.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TravelListingResponse(
    val listings: List<TravelListingDto?>?,
    val page: Int?,
    val pageSize: Int?,
    val total: Int?
)