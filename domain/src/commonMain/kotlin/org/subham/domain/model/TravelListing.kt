package org.subham.domain.model


data class TravelListing(

    val amenities: List<String?>?,
    val availableFrom: String?,
    val availableTo: String?,
    val capacity: Int?,
    val category: String?,
    val city: String?,
    val country: String?,
    val currency: String?,
    val description: String?,
    val id: String?,
    val images: List<String?>?,
    val isActive: Boolean?,
    val location: String?,
    val price: Double?,
    val rating: Float?,
    val reviewCount: Int?,
    val title: String?,
    val tripDates: List<TripDate?>?,
    val vendorId: String?
)