package com.example.rebonesw.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.rebonesw.ui.screen.screeningtest.ScreeningTestInfoScreen
import com.example.rebonesw.ui.theme.ReboneSWTheme
import com.example.rebonesw.viewmodels.ScreeningTestViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScreeningTestActivity: ComponentActivity() {
    private val vm: ScreeningTestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReboneSWTheme {
                vm.let { ScreeningTestInfoScreen(
                    vm = vm,
                    completeAnswers = CompleteScreenTest
                ) }
            } //ReboneSWTheme
        } //setContent
    } //onCreate

    private val CompleteScreenTest: () -> Unit = {
        startActivity(Intent(this@ScreeningTestActivity, MainActivity::class.java))
        finish()
    }

} //ScreeningTestActivity