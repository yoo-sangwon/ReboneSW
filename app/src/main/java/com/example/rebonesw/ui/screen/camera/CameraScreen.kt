package com.example.rebonesw.ui.screen.camera

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.rebonesw.R

@Composable
fun CameraScreen(
    state: CameraState,
    onEvent: (CameraEvent) -> Unit
) {

    if (!state.permitCamera) {
        CheckpermissionComponent { granted ->
            onEvent(CameraEvent.GrantCameraPermission(granted))
        }
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize().weight(0.8f)) {
                CameraComponent(state = state)
            }
            Box(modifier = Modifier.fillMaxSize().weight(0.2f)){
                Image(
                    painterResource(id = R.drawable.baseline_cameraswitch_36),
                    contentDescription = "capture btn",
                    modifier = Modifier.clickable {
                        if (!state.capture) {
                            onEvent(CameraEvent.SelfCamMode)
                        }
                    }
                )
            }
        } //Column
    }
} //fun CameraScreen()