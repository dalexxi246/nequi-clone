package com.wh2.sample.nequiclone.auth.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.wh2.sample.nequiclone.auth.ui.screens.LoginLoadingScreen
import com.wh2.sample.nequiclone.auth.ui.screens.password.PasswordScreen
import com.wh2.sample.nequiclone.auth.ui.viewmodel.AuthViewModel
import com.wh2.sample.nequiclone.base.ui.extensions.hiltViewModelFromBackStackEntry

@Composable
fun PasswordRoute(
    navController: NavController,
    navigateToMainScreen: () -> Unit
) {
    val authViewModel: AuthViewModel =
        navController.hiltViewModelFromBackStackEntry(ROUTE_AUTH)

    val uiState = authViewModel.uiState.collectAsState()

    val onBackPressed: () -> Unit = {
        authViewModel.updateUserPassword(String())
        navController.popBackStack()
    }

    LaunchedEffect(uiState.value.isUserSignedUp) {
        if (uiState.value.isUserSignedUp) {
            navigateToMainScreen()
        }
    }

    if (uiState.value.isLoading) {
        LoginLoadingScreen(modifier = Modifier.fillMaxSize())
    } else {
        PasswordScreen(
            password = uiState.value.userPassword,
            authenticate = authViewModel::login,
            onBackPressed = onBackPressed,
            updatePassword = authViewModel::updateUserPassword,
            modifier = Modifier.fillMaxSize()
        )
    }
}

internal const val ROUTE_AUTH_PASSWORD = "auth/password"
