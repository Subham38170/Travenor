package org.subham.presentation.feature.listings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.subham.domain.usecase.GetAllListingUseCase

class TravelListingViewModel(
    private val getAllListingUseCase: GetAllListingUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TravelListingUiState())
    val uiState = _uiState.asStateFlow()

    init {

        loadTravelListings()
    }

    private fun loadTravelListings() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

            try {

                getAllListingUseCase.execute().collect { listings ->
                    _uiState.update {
                        it.copy(
                            listings = listings,
                            isLoading = false,
                            errorMessage = null
                        )
                    }
                }

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Failed to load listings : ${e.message}"
                    )
                }
            }
        }
    }
}