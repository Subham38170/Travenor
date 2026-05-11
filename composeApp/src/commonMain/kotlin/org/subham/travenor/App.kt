package org.subham.travenor

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import org.subham.data.repository.ListingRepositoryImpl
import org.subham.domain.usecase.GetAllListingUseCase
import org.subham.presentation.feature.listings.TravelListingViewModel
import org.subham.travenor.ui.listings.HomeListingScreen

@Composable
@Preview
fun App() {

    MaterialTheme {
        HomeListingScreen()
    }
}