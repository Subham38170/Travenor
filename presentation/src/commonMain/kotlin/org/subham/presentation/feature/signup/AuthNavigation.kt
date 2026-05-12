package org.subham.presentation.feature.signup

sealed class AuthNavigation {
    object ToLogin : AuthNavigation()
    object ToSignUp : AuthNavigation()
    object ToListing: AuthNavigation()
}