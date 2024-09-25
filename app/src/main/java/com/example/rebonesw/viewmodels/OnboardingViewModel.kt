package com.example.rebonesw.viewmodels

import androidx.lifecycle.ViewModel
import com.example.rebonesw.data.navigation.OnboardingDestination
import com.example.rebonesw.data.navigation.RegisterDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(

):ViewModel(){
    private val _OnboardingnavDestination = MutableStateFlow(OnboardingDestination.First)
    val OnboardingnavDestination: StateFlow<OnboardingDestination> get() = _OnboardingnavDestination
    fun updateOnboardingNavDestination(step : OnboardingDestination){
        _OnboardingnavDestination.value = step
    }
}