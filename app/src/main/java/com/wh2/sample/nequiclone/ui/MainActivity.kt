package com.wh2.sample.nequiclone.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.wh2.sample.nequiclone.auth.ui.navigation.ROUTE_AUTH
import com.wh2.sample.nequiclone.auth.ui.navigation.authNavigation
import com.wh2.sample.nequiclone.base.ui.theme.NequiCloneTheme
import com.wh2.sample.nequiclone.dashboard.ui.navigation.dashboardNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NequiCloneTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(navController, ROUTE_AUTH) {
                        authNavigation(navController)
                        dashboardNavigation(navController)
                    }
                }
            }
        }
    }
}
