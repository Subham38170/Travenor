package org.subham.travenor.ui.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.viewmodel.koinViewModel
import org.subham.presentation.feature.signup.AuthNavigation
import org.subham.presentation.feature.signup.SignUpViewModel
import org.subham.travenor.navigation.NavRoutes
import org.subham.travenor.widgets.TravenorCircleImageButton
import org.subham.travenor.widgets.TravenorPasswordTextField
import org.subham.travenor.widgets.TravenorSpacer
import org.subham.travenor.widgets.TravenorTextField

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = koinViewModel<SignUpViewModel>(),
    backstack: SnapshotStateList<NavRoutes>
) {
    val uiState = viewModel.uiState.collectAsState()
    val name = viewModel.name.collectAsState()
    val password = viewModel.password.collectAsState()
    val confirmPassword = viewModel.confirmPassword.collectAsState()
    val email = viewModel.email.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.navigationState.collectLatest {
            when (it) {

                is AuthNavigation.ToLogin -> {
                    backstack.apply {
                        clear()
                        add(NavRoutes.Login)
                    }
                }

                is AuthNavigation.ToListing -> {
                    backstack.apply {
                        clear()
                        add(NavRoutes.Listing)
                    }
                }

                else -> {

                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        TravenorSpacer(
            size = 16.dp
        )

        TravenorCircleImageButton(
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Arrow Back",
            onClick = {}
        )
        TravenorSpacer(20.dp)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                text = "Sign up now",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall.copy(fontSize = 28.sp)
            )
            TravenorSpacer(8.dp)
            Text(
                text = "Please sign up to continue our app",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            TravenorSpacer(24.dp)
            TravenorTextField(
                value = name.value,
                onValueChange = {
                    viewModel.onNameChange(it)
                },
                modifier = Modifier
                    .widthIn(min = 400.dp, max = 600.dp),
                placeholder = {
                    Text(
                        text = "Full Name",
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                        fontSize = 16.sp
                    )
                }
            )
            TravenorSpacer(16.dp)
            TravenorTextField(
                value = email.value,
                onValueChange = {
                    viewModel.onEmailChange(it)
                },
                modifier = Modifier
                    .widthIn(min = 400.dp, max = 600.dp),
                placeholder = {
                    Text(
                        text = "Email Address",
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                        fontSize = 16.sp
                    )
                }
            )
            TravenorSpacer(16.dp)
            TravenorPasswordTextField(
                value = password.value,
                onValueChange = {
                    viewModel.onPasswordChange(it)
                },
                placeholder = {
                    Text(
                        text = "Password",
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                        fontSize = 16.sp
                    )
                },
                modifier = Modifier
                    .widthIn(min = 400.dp, max = 600.dp)
            )
            TravenorSpacer(16.dp)
            TravenorPasswordTextField(
                value = confirmPassword.value,
                onValueChange = {
                    viewModel.onConfirmPasswordChange(it)
                },
                placeholder = {
                    Text(
                        text = "Confirm Password",
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                        fontSize = 16.sp
                    )
                },
                modifier = Modifier
                    .widthIn(min = 400.dp, max = 600.dp)
            )
            Box(
                modifier = Modifier
                    .widthIn(min = 400.dp, max = 600.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                TextButton(
                    onClick = {

                    }
                ) {
                    Text(
                        text = "Forgot Password?",
                        color = MaterialTheme.colorScheme.primary
                    )
                }

            }



            Button(
                onClick = {
                    viewModel.signUp()
                },
                modifier = Modifier
                    .widthIn(min = 400.dp, max = 600.dp),
                shape = RoundedCornerShape(12.dp),
                enabled = !uiState.value.isLoading
            ) {
                Text(
                    text = "Create Account",
                )
            }
            uiState.value.errorMessage?.let {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Row(
                modifier = Modifier
                    .widthIn(min = 400.dp, max = 600.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Already have an account?",
                    color = MaterialTheme.colorScheme.onSurface.copy(0.7f)
                )
                TextButton(
                    onClick = {
                        viewModel.onSignInClick()
                    }
                ) {
                    Text(
                        text = "Sign In",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }


        }

    }
}