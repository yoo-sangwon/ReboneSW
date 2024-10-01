package com.example.rebonesw.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.rebonesw.ui.screen.main.MainScreen
import com.example.rebonesw.ui.theme.ReboneSWTheme
import com.example.rebonesw.viewmodels.MainViewMdoel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val vm: MainViewMdoel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReboneSWTheme {
                val sumsAnswersData by vm.screeningTestAnswersDataFlow.collectAsState()


                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("") },
                            navigationIcon = {
                                IconButton(onClick = { /* 메뉴 열기 동작 */ }) {
                                    Icon(Icons.Default.Menu, contentDescription = "메뉴")
                                }
                            }
                        )
                    },
                    ){ innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        vm = vm,
                        sumsAnswersData = sumsAnswersData.stAnswers01 + sumsAnswersData.stAnswers02 + sumsAnswersData.stAnswers03 + sumsAnswersData.stAnswers04 + sumsAnswersData.stAnswers05,
                        moveScreenTestInfo = {
                            startActivity(Intent(this, ScreeningTestActivity::class.java))
                        }
                    )
                } //Scaffold
            } // ReboneSWTheme
        } //setContent

    } //fun OnCreate

} //class MainActivity


