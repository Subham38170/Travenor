package org.subham.travenor

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import org.subham.presentation.feature.app.AppViewModel
import org.subham.travenor.navigation.TravenorNavRoot

@Composable
@Preview
fun App(
    viewModel: AppViewModel = koinViewModel<AppViewModel>()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    MaterialTheme {


        if (uiState.isLoading) {
            CircularProgressIndicator()

        } else {
            TravenorNavRoot(uiState.authToken)

        }
    }
}