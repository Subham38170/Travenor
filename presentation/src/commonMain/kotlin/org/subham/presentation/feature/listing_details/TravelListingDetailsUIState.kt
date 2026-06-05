package org.subham.presentation.feature.listing_details

import org.subham.domain.model.TravelListing

data class TravelListingDetailsUIState(
    val travelListing: TravelListing? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)