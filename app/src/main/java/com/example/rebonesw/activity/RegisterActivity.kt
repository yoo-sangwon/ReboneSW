package com.example.rebonesw.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.rebonesw.ui.screen.register.RegisterScreen
import com.example.rebonesw.ui.theme.ReboneSWTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            ReboneSWTheme {
                RegisterScreen()
            } //ReboneSWTheme
        } //setContent
    }
} //RegisterActivity