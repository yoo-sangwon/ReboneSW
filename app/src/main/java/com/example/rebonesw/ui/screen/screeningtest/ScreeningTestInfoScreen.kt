package com.example.rebonesw.ui.screen.screeningtest

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.rebonesw.viewmodels.ScreeningTestViewModel

@Composable
fun ScreeningTestInfo(
    vm: ScreeningTestViewModel
) {
    Column {
        Text(
            text = "SARC-F 검사"
        ) //Text

        Text(
            text = buildString {

            }
        ) //Text

        Button(
            onClick = {}
        ) {
            Text(
                text = "시작하기"
            )
        } //Button
    } //Column
} //fun ScreeningTestInfo