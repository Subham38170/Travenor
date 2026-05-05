package org.subham.domain.model


data class TravelListing(
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
) {
    fun geetFormattedPrice(): String {
        return "$${(pricePerNight)} / night"
    }

    fun getRatingDescription(): String {
        return when {
            rating >= 4.8 -> "Exceptional"
            rating >= 4.5 -> "Excellent"
            rating >= 4.0 -> "Very God"
            rating >= 3.5 -> "Good"
            rating >= 3.0 -> "Average"
            else -> "Below Average"
        }
    }
}