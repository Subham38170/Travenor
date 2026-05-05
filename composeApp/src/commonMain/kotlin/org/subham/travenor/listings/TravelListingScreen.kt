package org.subham.travenor.listings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.subham.domain.model.TravelListing
import org.subham.presentation.listings.TravelListingViewModel

@Composable
fun TravelListingScreen(
    viewModel: TravelListingViewModel
) {

    Scaffold {
        val listings = viewModel.uiState.collectAsStateWithLifecycle()
        LazyColumn {
            items(listings.value.listings) {

                TravelListingItem(it)
            }


        }
    }


}

@Composable
private fun TravelListingItem(
    listing: TravelListing
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = listing.title
        )
        Text(
            text = listing.description
        )
    }
}