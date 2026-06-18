package com.example.gameapplication.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameapplication.domain.usecase.RegisterUseCase
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state

    fun onNameChange(v: String) {
        _state.value = _state.value.copy(name = v)
    }

    fun onEmailChange(v: String) {
        _state.value = _state.value.copy(email = v)
    }

    fun onPasswordChange(v: String) {
        _state.value = _state.value.copy(password = v)
    }

    fun onUsernameChange(v: String) {
        _state.value = _state.value.copy(username = v)
    }

    fun onPhoneChange(v: String) {
        _state.value = _state.value.copy(phone = v)
    }

    fun register() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            try {
                registerUseCase(
                    _state.value.name,
                    _state.value.email,
                    _state.value.password,
                    _state.value.username,
                    _state.value.phone
                )

                _state.value = _state.value.copy(
                    isLoading = false,
                    success = true
                )

            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}