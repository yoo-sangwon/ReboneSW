package com.example.rebonesw

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.rebonesw.ui.screen.splash.LoginScreen
import com.example.rebonesw.ui.theme.ReboneSWTheme

class LoginActivity : ComponentActivity(){

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            ReboneSWTheme {
                LoginScreen()
            } //ReboneSWTheme
        } //setContent
    }
} //class