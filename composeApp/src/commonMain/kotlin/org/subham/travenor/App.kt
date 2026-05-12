package org.subham.travenor

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.subham.travenor.navigation.TravenorNavRoot
import org.subham.travenor.ui.listings.HomeListingScreen

@Composable
@Preview
fun App() {

    MaterialTheme {
        TravenorNavRoot()
    }
}