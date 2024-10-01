package com.example.rebonesw.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.rebonesw.ui.screen.onboarding.OnboardingScreen
import com.example.rebonesw.ui.theme.ReboneSWTheme
import com.example.rebonesw.viewmodels.OnboardingViewModel

class OnboardingActivity: ComponentActivity() {
    private val vm: OnboardingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ReboneSWTheme{
                OnboardingScreen(
                    skipScreenTestInfo = skipScreenTestInfo
                )
            }//ReboneSWTheme
        } //setContent
    } //onCreate

    private val skipScreenTestInfo: () -> Unit = {
        startActivity(Intent(this@OnboardingActivity, ScreeningTestActivity::class.java))
        finish()
    }
} //class OnboardingActivity