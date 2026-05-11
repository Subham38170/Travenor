package org.subham.travenor.ui.listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.subham.domain.model.TravelListing
import org.subham.presentation.feature.listings.TravelListingViewModel
import org.subham.travenor.theme.Orange
import org.subham.travenor.theme.PrimaryBlue
import org.subham.travenor.widgets.MultiHighlightedText
import org.subham.travenor.widgets.TextHighlight
import org.subham.travenor.widgets.TravenorSpacer
import travenor.composeapp.generated.resources.Res
import travenor.composeapp.generated.resources.default_listing_img
import travenor.composeapp.generated.resources.notifications
import travenor.composeapp.generated.resources.user

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun pvw() {
    HomeListingScreen()
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeListingScreen(
    viewModel: TravelListingViewModel = koinViewModel<TravelListingViewModel>()
) {

    val uiState = viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(32.dp))
                            .background(Color.LightGray.copy(0.2f))
                            .padding(8.dp)

                    ) {
                        Image(
                            painter = painterResource(Res.drawable.user),
                            contentDescription = "Profile photo"
                        )
                        Text(
                            text = "Leornado"
                        )
                    }


                },
                actions = {
                    Image(
                        painter = painterResource(Res.drawable.notifications),
                        contentDescription = "Notification icon",
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .size(48.dp)
                            .background(color = Color.LightGray.copy(0.2f), shape = CircleShape)
                            .padding(12.dp)
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MultiHighlightedText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                fullText = "Explore the \nbeautiful world!",
                highlights = listOf(
                    TextHighlight(
                        word = "world!",
                        color = Orange,
                        showUnderline = true,
                        fontWeight = FontWeight.Bold
                    ),
                    TextHighlight(
                        word = "beautiful",
                        color = Color.Black,
                        showUnderline = false,
                        fontWeight = FontWeight.Bold
                    )
                ),
                fontSize = 36.sp,
                peakHeight = 16.dp,
                thickness = 12.dp

            )
            TravenorSpacer(16.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Best Destination",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )
                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = "View All",
                        color = PrimaryBlue
                    )
                }
            }
            if (uiState.value.isLoading) {
                CircularProgressIndicator()
            }
            uiState.value.errorMessage?.let {
                Text(
                    text = it,
                    color = Color.Red,
                )
            }
            uiState.value.listings.takeIf { it.isNotEmpty() }?.let { listings ->
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(listings) { data ->
                        DestinationCard(
                            model = data
                        )
                    }
                }
            }
        }

    }
}


@Composable
fun DestinationCard(
    model: TravelListing
) {
    Column(
        modifier = Modifier
            .background(Color.Transparent, shape = RoundedCornerShape(16.dp))
            .width(250.dp),
        verticalArrangement = Arrangement.Center
    ) {

        AsyncImage(
            model = model.images?.firstOrNull() ?: painterResource(Res.drawable.default_listing_img),
            contentDescription = "Resort",
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .size(240.dp),
            contentScale = ContentScale.FillBounds,
            placeholder = painterResource(Res.drawable.default_listing_img)

        )
        TravenorSpacer(8.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = model.title ?: "",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier
                    .weight(8f),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Text(
                text = "${model.rating}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier
                    .weight(2f),
                textAlign = TextAlign.End
            )
        }
        TravenorSpacer(8.dp)
        Text(
            text = "United States",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color.Gray
        )


    }
}