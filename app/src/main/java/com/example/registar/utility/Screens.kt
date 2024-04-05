package com.example.registar.utility

sealed class Screens(val route: String) {

    object signUpScreen : Screens("signUpScreen")
    object signInScreen : Screens("signInScreen")
    object homeScreen : Screens("homeScreen")
    object forgotPasswordScreen: Screens("forgotPasswordScreen")
}