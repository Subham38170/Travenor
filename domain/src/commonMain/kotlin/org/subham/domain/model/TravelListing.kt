package org.subham.domain.model


data class TravelListing(

    val id: String?,
    val images: List<String?>?,
    val location: String?,
    val rating: Float?,
    val title: String?
)