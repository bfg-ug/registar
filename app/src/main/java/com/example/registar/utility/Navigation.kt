package com.example.registar.utility

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registar.views.ForgotPassord
import com.example.registar.views.Homepage
import com.example.registar.views.SignInPage
import com.example.registar.views.SignUpPage

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.signInScreen.route ){
        composable(route =Screens.signUpScreen.route){
            SignUpPage(navController)
        }
        composable(route =Screens.signInScreen.route){
            SignInPage(navController)
        }
        composable(route =Screens.homeScreen.route){
            Homepage(navController)
        }
        composable(route =Screens.forgotPasswordScreen.route){
            ForgotPassord(navController)
        }
    }

}
