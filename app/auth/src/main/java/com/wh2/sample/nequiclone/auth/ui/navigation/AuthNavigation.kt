package com.wh2.sample.nequiclone.auth.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wh2.sample.nequiclone.auth.ui.screens.LoginScreen
import com.wh2.sample.nequiclone.auth.ui.screens.PasswordScreen

@Composable
fun AuthNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ROUTE_LOGIN) {
        composable(ROUTE_LOGIN) {
            LoginScreen(
                onNextStepButtonClicked = { navController.navigate(ROUTE_PASSWORD) }
            )
        }
        composable(ROUTE_PASSWORD) { PasswordScreen() }
    }
}

internal const val ROUTE_LOGIN = "login"
internal const val ROUTE_PASSWORD = "login/password"
