package com.example.rebonesw.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.rebonesw.R

@Composable
fun SplashScreen(modifier: Modifier) {

    Column (
        modifier = modifier.fillMaxSize(), // 전체 화면을 채우도록 설정
        horizontalAlignment = Alignment.CenterHorizontally, // 수평으로 중앙 정렬
        verticalArrangement = Arrangement.Center // 수직으로도 중앙 정렬
    ){
//        Spacer(modifier = Modifier.weight(144f))
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally), // 이미지 수평 중앙 정렬
            painter = painterResource(id = R.drawable.rebone_logo),
            contentDescription = null
        )
    }
}