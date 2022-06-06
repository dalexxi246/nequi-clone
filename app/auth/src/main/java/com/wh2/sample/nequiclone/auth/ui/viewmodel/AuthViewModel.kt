package com.wh2.sample.nequiclone.auth.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wh2.sample.nequiclone.auth.ui.state.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun updateUserPhone(userPhone: String) {
        _uiState.update { it.copy(userPhone = userPhone) }
    }

    fun updateUserPassword(userPassword: String) {
        _uiState.update { it.copy(userPassword = userPassword) }
    }

    fun login() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            delay(3000)
            if (uiState.value.userPhone != "12345") {
                _uiState.update { it.copy(errorOnLoginFailed = "Usuario no registrado") }
            } else if (uiState.value.userPassword != "1234") {
                _uiState.update { it.copy(errorOnLoginFailed = "Contraseña incorrecta") }
            } else {
                _uiState.update { it.copy(isUserSignedUp = true) }
            }
        }
    }
}
