package org.subham.travenor.ui.details


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import org.subham.presentation.feature.listing_details.TravelListingDetailsViewModel
import org.subham.travenor.navigation.NavRoutes
import org.subham.travenor.widgets.TravenorCircleImageButton
import org.subham.travenor.widgets.TravenorSpacer
import travenor.composeapp.generated.resources.Res
import travenor.composeapp.generated.resources.bookmark_24px
import travenor.composeapp.generated.resources.location_on_24px
import travenor.composeapp.generated.resources.outline_star_24
import travenor.composeapp.generated.resources.user


@Composable
fun TravelItemDetailsScreen(
    backStack: SnapshotStateList<NavRoutes>,
    itemId: String,
    viewModel: TravelListingDetailsViewModel = koinViewModel<TravelListingDetailsViewModel> {
        parametersOf(itemId)
    }

) {

    val uiState = viewModel.uiState.collectAsState()

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (uiState.value.isLoading) {
                CircularProgressIndicator()
            } else if (uiState.value.errorMessage != null) {
                Text(
                    text = uiState.value.errorMessage ?: "Something went wrong"
                )
            }
            uiState.value.travelListing?.let {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    uiState.value.travelListing?.images?.let {
                        AsyncImage(
                            model = it.first(),
                            contentDescription = "Travel Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxWidth()
                                .height(400.dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    ) {
                        TravenorCircleImageButton(
                            onClick = {
                                backStack.removeLastOrNull()
                            },
                            contentDescription = "Back Arrow",
                            icon = Icons.AutoMirrored.Filled.ArrowBack

                        )
                        Text(
                            text = "Details",
                            modifier = Modifier.weight(1f).padding(16.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium
                        )
                        TravenorCircleImageButton(
                            onClick = {},
                            contentDescription = "Book Mark",
                            icon = painterResource(Res.drawable.bookmark_24px)
                        )
                    }

                }
            }

            Box(
                modifier = Modifier
                    .offset(y = (-36).dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.background)
            ) {

                Column(
                    modifier = Modifier
                        .padding(top = 32.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Column {
                            Text(
                                text = uiState.value.travelListing?.title ?: "",
                                style = MaterialTheme.typography.titleLarge

                            )

                            Text(
                                text = uiState.value.travelListing?.location ?: "",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                            )
                        }

                        TravenorCircleImageButton(
                            onClick = {},
                            icon = painterResource(Res.drawable.user),
                            contentDescription = "User",
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }

                    TravenorSpacer(16.dp)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.location_on_24px),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(end = 4.dp),
                                colorFilter = ColorFilter.tint(color = Color.Black)

                            )
                            Text(
                                text = uiState.value.travelListing?.country ?: "",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)

                            )
                        }

                        Row(

                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.outline_star_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(28.dp)
                                    .padding(end = 4.dp),
                                colorFilter = ColorFilter.tint(color = Color.Yellow.copy(5f))

                            )
                            Text(
                                text = uiState.value.travelListing?.rating.toString(),
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "${uiState.value.travelListing?.rating ?: "N/A"}/Person",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                            )
                        }

                        Text(
                            text = "${uiState.value.travelListing?.rating ?: "N/A"}/Person",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )

                    }
                    TravenorSpacer(16.dp)

                    uiState.value.travelListing?.images?.let {
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(it) {

                                AsyncImage(
                                    model = it,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(56.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                    )
                    Text(
                        text = uiState.value.travelListing?.description ?: "",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        onClick = {},
                        shape = RoundedCornerShape(12.dp)
                    ){
                        Text(
                            text = "Book Now",
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                        )
                    }
                }

            }
        }
    }

}
