package org.subham.presentation.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.subham.presentation.feature.app.AppViewModel
import org.subham.presentation.feature.listing_details.TravelListingDetailsViewModel
import org.subham.presentation.feature.listings.TravelListingViewModel
import org.subham.presentation.feature.signin.SignInViewModel
import org.subham.presentation.feature.signup.SignUpViewModel

val presentationModule = module {
    viewModel { TravelListingViewModel(get()) }

    viewModel { SignInViewModel(get()) }
    viewModel { SignUpViewModel(get()) }

    viewModel { TravelListingDetailsViewModel(get()) }

    viewModel { AppViewModel(get()) }
}