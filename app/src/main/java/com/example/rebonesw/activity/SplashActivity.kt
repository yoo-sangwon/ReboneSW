package com.example.rebonesw.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.rebonesw.ui.screen.splash.SplashScreen
import com.example.rebonesw.ui.theme.ReboneSWTheme
import com.example.rebonesw.viewmodels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity: ComponentActivity(){
    private val vm: SplashViewModel by viewModels()

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
        vm.registerData?.let{
            startActivity(Intent(this@SplashActivity, RegisterActivity::class.java))
            finish()
        } ?: run {
            startActivity(Intent(this@SplashActivity, RegisterActivity::class.java))
            finish()
        }


    } //goToMain
} // class SplashActivity