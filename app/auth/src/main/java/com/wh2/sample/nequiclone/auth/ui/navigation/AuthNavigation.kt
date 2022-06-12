package com.wh2.sample.nequiclone.auth.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.wh2.sample.nequiclone.auth.ui.screens.LoginScreen
import com.wh2.sample.nequiclone.auth.ui.screens.PasswordScreen
import com.wh2.sample.nequiclone.auth.ui.viewmodel.AuthViewModel

@Composable
fun AuthNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ROUTE_AUTH) {
        navigation(ROUTE_AUTH_LOGIN, ROUTE_AUTH) {
            composable(ROUTE_AUTH_LOGIN) {
                val authViewModel: AuthViewModel =
                    navController.hiltViewModelFromBackStackEntry(ROUTE_AUTH)
                LoginScreen(
                    onNextStepButtonClicked = { navController.navigate(ROUTE_AUTH_PASSWORD) },
                    authViewModel = authViewModel
                )
            }
            composable(ROUTE_AUTH_PASSWORD) {
                val authViewModel: AuthViewModel =
                    navController.hiltViewModelFromBackStackEntry(ROUTE_AUTH)
                val uiState = authViewModel.uiState.collectAsState()
                PasswordScreen(
                    password = uiState.value.userPassword,
                    isLoading = uiState.value.isLoading,
                    isUserSignedUp = uiState.value.isUserSignedUp,
                    updatePassword = authViewModel::updateUserPassword,
                    authenticate = authViewModel::login,
                    onBackPressed = navController::popBackStack
                )
            }
        }
    }
}

@Composable
inline fun <reified VM : ViewModel> NavController.hiltViewModelFromBackStackEntry(route: String): VM {
    val parentEntry = remember { getBackStackEntry(route) }
    return hiltViewModel(parentEntry)
}

internal const val ROUTE_AUTH = "auth"
internal const val ROUTE_AUTH_LOGIN = "auth/login"
internal const val ROUTE_AUTH_PASSWORD = "auth/password"
