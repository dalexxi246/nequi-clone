package com.wh2.sample.nequiclone.auth.ui.state

data class LoginUiState(
    val isLoading: Boolean = false,
    val userPhone: String = String(),
    val userPassword: String = String(),
    val errorOnLoginFailed: String = String(),
    val isUserSignedUp: Boolean = false
)
