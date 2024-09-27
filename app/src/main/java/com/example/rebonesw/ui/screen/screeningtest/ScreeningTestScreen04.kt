package com.example.rebonesw.ui.screen.screeningtest

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.rebonesw.data.navigation.ScreeningTestDestination

@Composable
fun ScreeningTestScreen04(
    moveScreen: (ScreeningTestDestination) -> Unit
) {
    Column {
        Text(
            text = "4번"
        ) //Text

        Text(
            text = buildString {

            }
        ) //Text

        Button(
            onClick = {
                moveScreen(ScreeningTestDestination.SurveyScreen05)
            }
        ) {
            Text(
                text = "시작하기"
            )
        } //Button
    } //Column
}