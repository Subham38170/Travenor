package org.subham.presentation.feature.listing_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.subham.domain.usecase.GetListingByIdUseCase

class TravelListingDetailsViewModel(
    private val getListingByIdUseCase: GetListingByIdUseCase,
    private val itemId: String
) : ViewModel() {

    private val _uiState = MutableStateFlow(TravelListingDetailsUIState())
    val uiState = _uiState.asStateFlow()


    init {
        loadListingDetails()
    }

    private fun loadListingDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }
            getListingByIdUseCase.execute(itemId).onSuccess { listing ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        travelListing = listing
                    )
                }
            }.onFailure { e ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = e.message
                    )
                }
            }

        }
    }
}