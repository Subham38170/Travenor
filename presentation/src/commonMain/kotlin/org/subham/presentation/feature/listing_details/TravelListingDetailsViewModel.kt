package org.subham.presentation.feature.listing_details

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TravelListingDetailsViewModel(
    val itemId: String
): ViewModel() {

    private val _uiState = MutableStateFlow(TravelListingDetailsUIState())
    val uiState = _uiState.asStateFlow()


    init {

        loadTravelListingDetails()
    }
    private fun loadTravelListingDetails(){
        println("Travel Listing Id : ${itemId}")
    }
}