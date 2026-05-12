package org.subham.travenor.ui.details


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import io.ktor.http.parametersOf
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import org.subham.presentation.feature.listing_details.TravelListingDetailsViewModel
import org.subham.travenor.navigation.NavRoutes

@Composable
fun TravelItemDetailsScreen(
    backStack: SnapshotStateList<NavRoutes>,
    itemId: String,
    viewModel: TravelListingDetailsViewModel = koinViewModel<TravelListingDetailsViewModel>{
        parametersOf(itemId)
    }

) {

    val uiState = viewModel.uiState.collectAsState()

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
        ){

        }
    }


}