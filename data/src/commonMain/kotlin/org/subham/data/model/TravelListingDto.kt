package org.subham.data.model

data class TravelListingDto(
    val id: String,
    val title: String,
    val description: String,
    val location: String,
    val imageUrl: String,
    val pricePerNight: String,
    val rating: Double,
    val amenities: List<String> = emptyList(),
    val hostName: String,
    val isFavorite: Boolean = false
)