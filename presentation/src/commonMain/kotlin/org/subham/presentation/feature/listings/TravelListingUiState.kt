package org.subham.presentation.feature.listings

import org.subham.domain.model.TravelListing

data class TravelListingUiState(
    val listings: List<TravelListing> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
){
    val hasListings: Boolean
        get() = !isLoading && !hasListings && errorMessage == null
    val showEmptyState: Boolean
        get() = !isLoading && !hasListings && errorMessage != null
}