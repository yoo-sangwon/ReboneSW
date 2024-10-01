package com.example.rebonesw.ui.screen.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    skipScreenTestInfo: () -> Unit
) {
//    var currentScreen by remember { mutableStateOf(1) }
    val pagerState = rememberPagerState(pageCount = { 3 }, initialPage = 0)
    val scope = rememberCoroutineScope() // 코루틴 스코프 선언


    Column(modifier = Modifier.fillMaxSize()) {

        HorizontalPager (
            state = pagerState,
            modifier = Modifier.fillMaxHeight(0.8f)
                .padding(8.dp),
        ) { page ->
            when (page) {
                0 -> FirstOnboardingScreen()
                1 -> SecondOnboardingScreen()
                2 -> LastOnboardingScreen()
            }
        } //HorizontalPager

        // 페이지 인디케이터 표시
        PageIndicator(currentPage = pagerState.currentPage, totalPages = 3)

        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 32.dp),
            contentAlignment = Alignment.Center // 버튼을 화면 중앙에 정렬
        ) {
            if(pagerState.currentPage < 2){
                // 1,2 번째 페이지 에서는 하단의 버튼이 생략하기, 다음 으로 노출
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Button(
                        onClick = {
                            skipScreenTestInfo()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Black
                        )
                    ) {
                        Text(
                            text = "생략하기",
                            fontSize = 18.sp
                        )
                    }

                    Button(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color(0xFFF15B5B)
                        ),
                    ) {
                        Text(
                            text = "다음",
                            fontSize = 18.sp
                        )
                    }
                } //Row
            } else {
                // 마지막 페이지에서는 하단 버튼이 확인 으로 노출
                Button(
                    onClick = {
                        skipScreenTestInfo()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF15B5B),
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                ) {
                    Text(text = "시작하기", fontSize = 18.sp)
                }
            }
        } //Box
    } //Column
} //fun OnboardingScreen()

@Composable
fun PageIndicator(currentPage: Int, totalPages: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(totalPages) { pageIndex ->
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(if (pageIndex == currentPage) Color.Red else Color.LightGray)
            )
        }
    }
} //fun PageIndicator