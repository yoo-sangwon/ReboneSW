package com.example.rebonesw.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.rebonesw.data.navigation.ScreeningTestDestination
import com.example.rebonesw.ui.screen.screeningtest.ScreeningTestInfo
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
                val navDestinationProperties by vm.navDestination.collectAsState()

                when (navDestinationProperties){
                    ScreeningTestDestination.infoScreen -> {
                        ScreeningTestInfo(vm)
                    }
                    ScreeningTestDestination.SurveyScreen01 ->{}
                    ScreeningTestDestination.SurveyScreen02 ->{}
                    ScreeningTestDestination.SurveyScreen03 ->{}
                    ScreeningTestDestination.SurveyScreen04 ->{}
                    ScreeningTestDestination.SurveyScreen05 ->{}
                }
            } //ReboneSWTheme
        } //setContent
    } //onCreate

} //ScreeningTestActivity