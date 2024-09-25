package com.example.rebonesw.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebonesw.R

@Composable
fun LastOnboardingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            // 이미지
            Image(
                painter = painterResource(id = R.drawable.onboarding03), // 이미지 파일 넣기
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )

            // 텍스트 영역
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Text(
                    text = "리본은 빠르고 쉽게 검사합니다.",
                    fontSize = 24.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )

                Spacer( modifier = Modifier.height(16.dp))

                Text(
                    text = "리본은 근감소증의 핵심 평가 지표인 근력, 신체 기능을 일상 생활에서도 빠르고 쉽게 검사할 수 있는 환경을 제공합니다. \n" +
                            "\n" +
                            "리본과 함께 여러분의 근육 상태를 확인하고, 튼튼한 노화를 위해 첫 걸음을 내딛어보세요!\uD83D\uDE01",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        } //Column
    }
}