package com.wh2.sample.nequiclone.auth.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wh2.sample.nequiclone.auth.ui.state.LoginUiState
import com.wh2.sample.nequiclone.auth.ui.state.LoginUiState.Companion.errorOnLogin
import com.wh2.sample.nequiclone.auth.ui.state.LoginUiState.Companion.loadingOff
import com.wh2.sample.nequiclone.auth.ui.state.LoginUiState.Companion.loadingOn
import com.wh2.sample.nequiclone.auth.ui.state.LoginUiState.Companion.userSignedUp
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
        _uiState.update { it.loadingOn() }
        viewModelScope.launch {
            delay(3000)
            _uiState.update { it.loadingOff() }
            if (uiState.value.userPhone != "12345") {
                _uiState.update { it.errorOnLogin() }
            } else if (uiState.value.userPassword != "1234") {
                _uiState.update { it.errorOnLogin() }
            } else {
                _uiState.update { it.userSignedUp() }
            }
        }
    }
}
