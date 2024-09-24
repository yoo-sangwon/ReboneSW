package com.example.rebonesw.ui.screen.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebonesw.R

@Composable
fun RegisterCompletedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column {
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(bottom = 32.dp), // 이미지 수평 중앙 정렬
                painter = painterResource(id = R.drawable.check_circle),
                contentDescription = null
            )
            Text(
                text = "실험 참여를 위한\n" +
                        "정보 입력을 완료했습니다.",
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                lineHeight = 36.sp
            )
        }
    } //Box
} //fun RegisterCompletedScreen()