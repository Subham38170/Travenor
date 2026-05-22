package org.subham.presentation.feature.app

import org.subham.domain.model.TravelListing

data class AppUiState(
    val isLoading: Boolean = false,
    val authToken: String? = null
)