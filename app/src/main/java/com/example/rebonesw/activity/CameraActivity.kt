package com.example.rebonesw.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rebonesw.ui.screen.camera.CameraScreen
import com.example.rebonesw.ui.theme.ReboneSWTheme
import com.example.rebonesw.viewmodels.CameraViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReboneSWTheme {
                val viewModel: CameraViewModel = hiltViewModel()
                val state by viewModel.state.collectAsState()
                CameraScreen(
                    state = state,
                    onEvent = viewModel::onEvent
                ) //CameraScreen
            } //ReboneSWTheme
        } //setContent
    } //onCreate
} //CameraActivity