package com.example.rebonesw.viewmodels

import androidx.lifecycle.ViewModel
import com.example.rebonesw.data.RegisterData
import com.example.rebonesw.data.ScreeningTestAnswersData
import com.example.rebonesw.repository.local.RegisterInfo
import com.example.rebonesw.repository.local.ScreeningTestAnswersInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewMdoel @Inject constructor(
    private val registerInfo: RegisterInfo,
    private val screeningTestAnswersInfo : ScreeningTestAnswersInfo
):ViewModel() {

    val registerData get() = registerInfo.data.value
    val screeningTestAnswersData get() = screeningTestAnswersInfo.data.value

}