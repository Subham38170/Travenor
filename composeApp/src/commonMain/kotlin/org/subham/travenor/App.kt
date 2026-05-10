package org.subham.travenor

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import org.subham.data.datasource.DummyDataSource
import org.subham.data.repository.ListingRepositoryImpl
import org.subham.domain.usecase.GetAllListingUseCase
import org.subham.presentation.feature.listings.TravelListingViewModel
import org.subham.travenor.ui.signin.LoginScreen
import org.subham.travenor.ui.signup.SignUpScreen

@Composable
@Preview
fun App() {
    val travelListingViewModel = viewModel {
        TravelListingViewModel(GetAllListingUseCase(ListingRepositoryImpl(DummyDataSource())))

    }
    MaterialTheme {
        SignUpScreen()
    }
}