package org.subham.travenor

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.subham.presentation.feature.app.AppViewModel
import org.subham.travenor.navigation.TravenorNavRoot

@Composable
@Preview
fun App(
    viewModel: AppViewModel = koinViewModel<AppViewModel>()
) {

    val uiState = viewModel.uiState.collectAsState()
    MaterialTheme {


        if (!uiState.value.isLoading) {

            TravenorNavRoot(uiState.value.authToken)
        } else {
            CircularProgressIndicator()
        }
    }
}