package com.example.rebonesw.viewmodels

import androidx.lifecycle.ViewModel
import com.example.rebonesw.repository.local.RegisterInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val registerInfo: RegisterInfo
): ViewModel() {
    val registerData get() = registerInfo.data.value
}