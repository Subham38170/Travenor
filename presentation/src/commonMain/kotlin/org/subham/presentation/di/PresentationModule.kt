package org.subham.presentation.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.subham.presentation.listings.TravelListingViewModel

val presentationModule = module {
    viewModel { TravelListingViewModel(get()) }
}