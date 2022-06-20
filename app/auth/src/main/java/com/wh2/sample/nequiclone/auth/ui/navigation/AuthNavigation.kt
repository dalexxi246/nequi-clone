package com.wh2.sample.nequiclone.auth.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

fun NavGraphBuilder.authNavigation(navController: NavController) {
    navigation(ROUTE_AUTH_LOGIN, ROUTE_AUTH) {
        composable(ROUTE_AUTH_LOGIN) {
            LoginRoute(navController = navController)
        }
        composable(ROUTE_AUTH_PASSWORD) {
            PasswordRoute(
                navController = navController,
                navigateToMainScreen = {
                    navController.navigate("xyz") {
                        popUpTo(ROUTE_AUTH) { inclusive = true }
                    }
                }
            )
        }
        composable("xyz") {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Cyan)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text(text = "XYZ")
                }
            }
        }
    }
}

const val ROUTE_AUTH = "auth"
