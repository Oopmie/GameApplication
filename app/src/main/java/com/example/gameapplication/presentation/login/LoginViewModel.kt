package com.example.gameapplication.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameapplication.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch


class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun onEmailChange(v: String) {
        _state.value = _state.value.copy(email = v)
    }

    fun onPasswordChange(v: String) {
        _state.value = _state.value.copy(password = v)
    }

    fun login(onSuccess: () -> Unit) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            try {
                loginUseCase(
                    _state.value.email,
                    _state.value.password
                )

                _state.value = _state.value.copy(
                    isLoading = false,
                    success = true
                )

                onSuccess()

            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}