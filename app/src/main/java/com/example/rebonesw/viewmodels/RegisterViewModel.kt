package com.example.rebonesw.viewmodels

import androidx.lifecycle.ViewModel
import com.example.rebonesw.data.RegisterData
import com.example.rebonesw.data.navigation.RegisterDestination
import com.example.rebonesw.repository.local.RegisterInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerInfo: RegisterInfo
): ViewModel() {
    private val _navDestination = MutableStateFlow(RegisterDestination.RegisterScreen)
    val navDestination: StateFlow<RegisterDestination> get() = _navDestination
    fun updateNavDestination(step : RegisterDestination){
        _navDestination.value = step
    }

    fun updateRegister( registerdata: RegisterData){
        registerInfo.update(registerdata)
    }

} //class RegisterViewModel