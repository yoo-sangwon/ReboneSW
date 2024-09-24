package com.example.rebonesw.viewmodels

import androidx.lifecycle.ViewModel
import com.example.rebonesw.data.RegisterData
import com.example.rebonesw.repository.local.RegisterInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerInfo: RegisterInfo
): ViewModel() {

    fun updateRegister( registerdata: RegisterData){
        registerInfo.update(registerdata)
    }

} //class RegisterViewModel