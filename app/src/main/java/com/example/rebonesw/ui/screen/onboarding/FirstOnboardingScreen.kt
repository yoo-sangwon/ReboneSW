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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebonesw.R

@Composable
fun FirstOnboardingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            // 이미지
            Image(
                painter = painterResource(id = R.drawable.onboarding01), // 이미지 파일 넣기
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
                    text = "근감소증이란?",
                    fontSize = 24.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )

                Spacer( modifier = Modifier.height(16.dp))

                Text(
                    text = buildAnnotatedString {
                        append("근감소증은 ")
                        withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)) {
                            append("나이가 들면서 근육량과 근력이 감소하는 상태를 말합니다.")
                        }
                        append("\n이는 일상생활의 활동 능력을 저하시킬 수 있으며, 낙상 등의 위험을 증가시킬 수 있습니다.\n")
                        append("근감소증의 ")
                        withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)) {
                            append("조기 발견")
                        }
                        append("은 근감소증의 진행을 늦추고 건강한 삶을 유지하는 데 중요합니다.")
                    },
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = Color.Gray
                )

            }
        } //Column
    } //Box
}