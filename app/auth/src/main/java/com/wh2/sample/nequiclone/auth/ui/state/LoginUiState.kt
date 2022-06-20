package com.wh2.sample.nequiclone.auth.ui.state

data class LoginUiState(
    val isLoading: Boolean = false,
    val userPhone: String = String(),
    val userPassword: String = String(),
    val isUserSignedUp: Boolean = false
) {
    companion object {
        fun LoginUiState.loadingOn() = copy(isLoading = true)

        fun LoginUiState.loadingOff() = copy(isLoading = false)

        fun LoginUiState.userSignedUp() = copy(
            isLoading = false,
            isUserSignedUp = true,
            userPhone = String(),
            userPassword = String()
        )

        fun LoginUiState.errorOnLogin() = copy(
            isLoading = false,
            isUserSignedUp = false,
            userPassword = String()
        )
    }
}
