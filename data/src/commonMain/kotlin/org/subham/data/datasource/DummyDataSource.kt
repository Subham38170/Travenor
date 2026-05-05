package org.subham.data.datasource

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.subham.data.model.TravelListingDto

class DummyDataSource {

    private val _listings = MutableStateFlow(createDummyListings())
    val listings = _listings.asStateFlow()


    private fun createDummyListings(): List<TravelListingDto> {
        return listOf(
            TravelListingDto(
                id = "1",
                title = "Beachside Villa",
                description = "Beautiful villa near the beach",
                location = "Goa",
                imageUrl = "https://example.com/img1.jpg",
                pricePerNight = "₹4500",
                rating = 4.5,
                amenities = listOf("WiFi", "Pool", "AC"),
                hostName = "Rahul",
                isFavorite = true
            ),
            TravelListingDto(
                id = "2",
                title = "Mountain Retreat",
                description = "Peaceful stay in the hills",
                location = "Manali",
                imageUrl = "https://example.com/img2.jpg",
                pricePerNight = "₹3000",
                rating = 4.2,
                amenities = listOf("WiFi", "Heater"),
                hostName = "Amit"
            ),
            TravelListingDto(
                id = "3",
                title = "City Apartment",
                description = "Modern apartment in city center",
                location = "Bangalore",
                imageUrl = "https://example.com/img3.jpg",
                pricePerNight = "₹3500",
                rating = 4.0,
                amenities = listOf("WiFi", "Parking"),
                hostName = "Sneha"
            ),
            TravelListingDto(
                id = "4",
                title = "Luxury Resort",
                description = "5-star luxury experience",
                location = "Udaipur",
                imageUrl = "https://example.com/img4.jpg",
                pricePerNight = "₹8000",
                rating = 4.8,
                amenities = listOf("Pool", "Spa", "Gym"),
                hostName = "Vikram"
            ),
            TravelListingDto(
                id = "5",
                title = "Cozy Cottage",
                description = "Small cozy cottage",
                location = "Ooty",
                imageUrl = "https://example.com/img5.jpg",
                pricePerNight = "₹2500",
                rating = 3.9,
                amenities = listOf("Fireplace", "WiFi"),
                hostName = "Priya"
            ),
            TravelListingDto(
                id = "6",
                title = "Desert Camp",
                description = "Experience desert life",
                location = "Jaisalmer",
                imageUrl = "https://example.com/img6.jpg",
                pricePerNight = "₹4000",
                rating = 4.3,
                amenities = listOf("Campfire", "Dinner"),
                hostName = "Imran"
            ),
            TravelListingDto(
                id = "7",
                title = "Lake View Room",
                description = "Room with lake view",
                location = "Nainital",
                imageUrl = "https://example.com/img7.jpg",
                pricePerNight = "₹3200",
                rating = 4.1,
                amenities = listOf("WiFi", "Balcony"),
                hostName = "Rohit"
            ),
            TravelListingDto(
                id = "8",
                title = "Forest Cabin",
                description = "Stay in the forest",
                location = "Coorg",
                imageUrl = "https://example.com/img8.jpg",
                pricePerNight = "₹3800",
                rating = 4.6,
                amenities = listOf("WiFi", "Nature View"),
                hostName = "Anjali"
            ),
            TravelListingDto(
                id = "9",
                title = "Budget Hostel",
                description = "Affordable stay",
                location = "Delhi",
                imageUrl = "https://example.com/img9.jpg",
                pricePerNight = "₹1200",
                rating = 3.5,
                amenities = listOf("WiFi"),
                hostName = "Karan"
            ),
            TravelListingDto(
                id = "10",
                title = "Heritage Haveli",
                description = "Traditional heritage stay",
                location = "Jaipur",
                imageUrl = "https://example.com/img10.jpg",
                pricePerNight = "₹5000",
                rating = 4.7,
                amenities = listOf("WiFi", "Breakfast"),
                hostName = "Raj"
            ),
            TravelListingDto(
                id = "11",
                title = "Beach Hut",
                description = "Simple hut near beach",
                location = "Puri",
                imageUrl = "https://example.com/img11.jpg",
                pricePerNight = "₹2000",
                rating = 4.0,
                amenities = listOf("Fan", "WiFi"),
                hostName = "Suresh"
            ),
            TravelListingDto(
                id = "12",
                title = "Hilltop Villa",
                description = "Amazing hilltop views",
                location = "Mussoorie",
                imageUrl = "https://example.com/img12.jpg",
                pricePerNight = "₹6000",
                rating = 4.9,
                amenities = listOf("WiFi", "Balcony", "Fireplace"),
                hostName = "Neha"
            ),
            TravelListingDto(
                id = "13",
                title = "Studio Apartment",
                description = "Compact studio",
                location = "Mumbai",
                imageUrl = "https://example.com/img13.jpg",
                pricePerNight = "₹4200",
                rating = 4.1,
                amenities = listOf("WiFi", "Kitchen"),
                hostName = "Arjun"
            ),
            TravelListingDto(
                id = "14",
                title = "Farm Stay",
                description = "Experience rural life",
                location = "Punjab",
                imageUrl = "https://example.com/img14.jpg",
                pricePerNight = "₹2800",
                rating = 4.3,
                amenities = listOf("Organic Food", "WiFi"),
                hostName = "Gurpreet"
            ),
            TravelListingDto(
                id = "15",
                title = "Island Resort",
                description = "Private island experience",
                location = "Andaman",
                imageUrl = "https://example.com/img15.jpg",
                pricePerNight = "₹9000",
                rating = 4.9,
                amenities = listOf("Pool", "Beach Access"),
                hostName = "David"
            )
        )
    }
}