package com.example.rebonesw.viewmodels

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.example.rebonesw.ui.screen.camera.CameraEvent
import com.example.rebonesw.ui.screen.camera.CameraState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor():ViewModel() {

    // 내부에서 상태를 변경할 수 있는 MutableStateFlow
    private val _state = MutableStateFlow(CameraState())

    // 외부에서 읽기 전용으로 사용할 수 있는 StateFlow
    val state: StateFlow<CameraState> get() = _state

    fun onEvent(event: CameraEvent) {
        when (event) {
            is CameraEvent.SelfCamMode -> toggleSelfCamMode()
            is CameraEvent.Capture -> captureImage()
            is CameraEvent.CaptureProcessed -> processCapture()
            is CameraEvent.GrantCameraPermission -> handlePermission(event.permission)
            is CameraEvent.GetImageBitmap -> handleImageBitmap(event.bitmap) // TODO 처리 추가
        }
    }

    private fun toggleSelfCamMode() {
        _state.value = _state.value.copy(selfCam = !_state.value.selfCam)
    }

    private fun captureImage() {
        // 이미지 캡처 처리 로직 추가
    }

    private fun processCapture() {
        // 캡처한 이미지 처리 로직 추가
    }

    private fun handlePermission(granted: Boolean) {
        _state.value = _state.value.copy(permitCamera = granted)
    }

    private fun handleImageBitmap(bitmap: Bitmap) {
        _state.value = _state.value.copy(imageBitmap = bitmap)
    }

} //class CameraViewModel @Inject constructor():ViewModel()