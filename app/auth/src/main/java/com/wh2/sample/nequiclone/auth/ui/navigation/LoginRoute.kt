package com.wh2.sample.nequiclone.auth.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wh2.sample.nequiclone.auth.ui.screens.login.LoginScreen
import com.wh2.sample.nequiclone.auth.ui.viewmodel.AuthViewModel
import com.wh2.sample.nequiclone.base.ui.extensions.hiltViewModelFromBackStackEntry

@Composable
fun LoginRoute(navController: NavController) {
    val authViewModel: AuthViewModel =
        navController.hiltViewModelFromBackStackEntry(ROUTE_AUTH)
    LoginScreen(
        onNextStepButtonClicked = { navController.navigate(ROUTE_AUTH_PASSWORD) },
        authViewModel = authViewModel
    )
}

internal const val ROUTE_AUTH_LOGIN = "auth/login"
