package com.example.rebonesw.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.example.rebonesw.ui.theme.ReboneSWTheme

class LoginActivity : ComponentActivity(){

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            ReboneSWTheme {

            } //ReboneSWTheme
        } //setContent
    }
} //class