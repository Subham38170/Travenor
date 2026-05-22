package org.subham.travenor.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import org.subham.travenor.ui.details.TravelItemDetailsScreen
import org.subham.travenor.ui.listings.HomeListingScreen
import org.subham.travenor.ui.signin.LoginScreen
import org.subham.travenor.ui.signup.SignUpScreen

@Composable
fun TravenorNavRoot(
    authToken: String?
) {

    val backstack =
        rememberSaveable { mutableStateListOf<NavRoutes>(if (authToken == null) NavRoutes.Login else NavRoutes.Listing) }


    NavDisplay(
        backStack = backstack,
        entryProvider = entryProvider {
            entry<NavRoutes.Login> {
                LoginScreen(
                    backstack = backstack
                )
            }
            entry<NavRoutes.SignUp> {
                SignUpScreen(
                    backstack = backstack
                )
            }
            entry<NavRoutes.Listing> {
                HomeListingScreen(
                    backstack = backstack
                )
            }
            entry<NavRoutes.ListingDetails> {
                TravelItemDetailsScreen(
                    backStack = backstack,
                    itemId = it.id
                )
            }
        },
        entryDecorators = listOf(
            // Add the default decorators for managing scenes and saving state
            rememberSaveableStateHolderNavEntryDecorator(),
            // Then add the view model store decorator
            rememberViewModelStoreNavEntryDecorator()
        ),
    )

}
