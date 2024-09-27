package com.example.rebonesw.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.rebonesw.data.ScreeningTestAnswersData
import com.example.rebonesw.data.navigation.ScreeningTestDestination
import com.example.rebonesw.ui.screen.screeningtest.ScreeningTestInfoScreen
import com.example.rebonesw.ui.screen.screeningtest.ScreeningTestScreen01
import com.example.rebonesw.ui.screen.screeningtest.ScreeningTestScreen02
import com.example.rebonesw.ui.screen.screeningtest.ScreeningTestScreen03
import com.example.rebonesw.ui.screen.screeningtest.ScreeningTestScreen04
import com.example.rebonesw.ui.screen.screeningtest.ScreeningTestScreen05
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
                        vm.let { ScreeningTestInfoScreen(vm) }
                    }
                    ScreeningTestDestination.SurveyScreen01 ->{
                        ScreeningTestScreen01(
                            moveScreen = moveScreen
                        )
                    }
                    ScreeningTestDestination.SurveyScreen02 ->{
                        ScreeningTestScreen02(
                            moveScreen = moveScreen
                        )
                    }
                    ScreeningTestDestination.SurveyScreen03 ->{
                        ScreeningTestScreen03(
                            moveScreen = moveScreen
                        )
                    }
                    ScreeningTestDestination.SurveyScreen04 ->{
                        ScreeningTestScreen04(
                            moveScreen = moveScreen
                        )
                    }
                    ScreeningTestDestination.SurveyScreen05 ->{
                        ScreeningTestScreen05(
                            moveScreen = moveScreen
                        )
                    }
                }
            } //ReboneSWTheme
        } //setContent
    } //onCreate

    private val moveScreen: ( navdestination: ScreeningTestDestination ) -> Unit = {
        vm.updateNavDestination(it)
    }

} //ScreeningTestActivity