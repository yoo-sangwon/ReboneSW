package com.example.rebonesw.viewmodels

import androidx.lifecycle.ViewModel
import com.example.rebonesw.data.RegisterData
import com.example.rebonesw.data.ScreeningTestAnswersData
import com.example.rebonesw.repository.local.RegisterInfo
import com.example.rebonesw.repository.local.ScreeningTestAnswersInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewMdoel @Inject constructor(
    private val registerInfo: RegisterInfo,
    private val screeningTestAnswersInfo : ScreeningTestAnswersInfo
):ViewModel() {

    val registerData get() = registerInfo.data.value
    val screeningTestAnswersData get() = screeningTestAnswersInfo.data.value

    // StateFlow로 screeningTestAnswersDataFlow를 정의
    private val _screeningTestAnswersDataFlow = MutableStateFlow(screeningTestAnswersData ?: ScreeningTestAnswersData())
    val screeningTestAnswersDataFlow: StateFlow<ScreeningTestAnswersData> = _screeningTestAnswersDataFlow

    init {
        // 데이터 초기화 또는 변경 시 StateFlow로 업데이트
        screeningTestAnswersInfo.data.observeForever { newData ->
            _screeningTestAnswersDataFlow.value = newData ?: ScreeningTestAnswersData()
        }
    }

}