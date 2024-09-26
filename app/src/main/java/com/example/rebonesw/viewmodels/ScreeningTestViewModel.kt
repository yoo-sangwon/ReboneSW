package com.example.rebonesw.viewmodels

import androidx.lifecycle.ViewModel
import com.example.rebonesw.data.ScreeningTestAnswersData
import com.example.rebonesw.data.navigation.ScreeningTestDestination
import com.example.rebonesw.repository.local.ScreeningTestAnswersInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ScreeningTestViewModel @Inject constructor(
    private val screeningTestAnswersInfo : ScreeningTestAnswersInfo
):ViewModel() {
    private val _navDestination = MutableStateFlow(ScreeningTestDestination.infoScreen)
    val navDestination: StateFlow<ScreeningTestDestination> get() = _navDestination
    fun updateNavDestination(step: ScreeningTestDestination){
        _navDestination.value = step
    }

    fun updateScreeningTestAnswers( screeningTestAnswersData: ScreeningTestAnswersData ){
        screeningTestAnswersInfo.update(screeningTestAnswersData)
    }


} //class ScreeningTestViewModel