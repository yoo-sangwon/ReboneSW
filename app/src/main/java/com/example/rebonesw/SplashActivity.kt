package com.example.rebonesw

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.rebonesw.ui.screen.splash.SplashScreen
import com.example.rebonesw.ui.theme.ReboneSWTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity: ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReboneSWTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    ) { innerPadding ->
                    SplashScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                } //Scaffold
            } // ReboneSWTheme
        } //setContent

        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            goToMain()
        }

    } // onCreate

    private fun goToMain(){
        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        finish()
    } //goToMain
} // class SplashActivity