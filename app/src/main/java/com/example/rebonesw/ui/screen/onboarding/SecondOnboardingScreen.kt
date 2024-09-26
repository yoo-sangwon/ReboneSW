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
fun SecondOnboardingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            // 이미지
            Image(
                painter = painterResource(id = R.drawable.onboarding02), // 이미지 파일 넣기
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
                    text = "지속적인 추적 관찰이 중요합니다.",
                    fontSize = 24.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )

                Spacer( modifier = Modifier.height(16.dp))

                Text(
                    text = buildAnnotatedString {
                        append("근감소증은 진행성 질환으로, 초기에는 증상이 미미할 수 있지만, ")
                        withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)) {
                            append("시간이 지남에 따라 근력과 근육량이 급격히 감소합니다.\n\n")
                        }
                        append("따라서 근감소증의 효과적인 관리를 위해서는 \n")
                        append("지속적인 추적 관찰이 필수적입니다.")
                    },
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            } //Column
        } //Column
    } //Box
}