package com.wh2.sample.nequiclone.base.ui.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

@Composable
inline fun <reified VM : ViewModel> NavController.hiltViewModelFromBackStackEntry(route: String): VM {
    val parentEntry = remember { getBackStackEntry(route) }
    return hiltViewModel(parentEntry)
}
