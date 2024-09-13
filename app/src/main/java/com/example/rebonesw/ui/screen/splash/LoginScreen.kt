package com.example.rebonesw.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rebonesw.R

@Composable
fun LoginScreen(){
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var connectNumber by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(

        ) {
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(bottom = 32.dp), // 이미지 수평 중앙 정렬
                painter = painterResource(id = R.drawable.rebone_logo),
                contentDescription = null
            )
            Surface(
            modifier = Modifier.padding(bottom = 8.dp , start = 1.dp , end = 1.dp),
                shadowElevation = 8.dp, // 그림자 높이 설정
                shape = RoundedCornerShape(8.dp) // 선택적으로 모서리를 둥글게 설정
            ) {
                Column(
                    modifier = Modifier.padding(start = 16.dp , end = 16.dp)
                ){

                    Text(
                        modifier = Modifier.padding(top = 8.dp,bottom = 8.dp),
                        text = "이름"
                    )
                    TextField(
                        value = name,
                        onValueChange = { inputName -> name = inputName }
                    )

                    // 나이 입력 필드 (숫자만 입력받도록 처리)
                    Text(
                        modifier = Modifier.padding(top = 8.dp,bottom = 8.dp),
                        text = "나이"
                    )
                    TextField(
                        value = age,
                        onValueChange = { inputAge ->
                            // 숫자만 입력받기 위한 로직
                            if (inputAge.all { it.isDigit() }) {
                                age = inputAge
                            }
                        },
                        modifier = Modifier
                            .background(Color.White, shape = RoundedCornerShape(8.dp)) // 배경색을 흰색으로 설정
                            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)) // 둥근 모서리의 검정 테두리 추가
                    )

                    // 전화번호 입력 필드 (숫자만 입력받도록 처리)
                    Text(
                        modifier = Modifier.padding(top = 8.dp,bottom = 8.dp),
                        text = "전화번호"
                    )
                    TextField(
                        value = connectNumber,
                        onValueChange = { inputNumber ->
                            // 숫자만 입력받기 위한 로직
                            if (inputNumber.all { it.isDigit() }) {
                                connectNumber = inputNumber
                            }
                        },
                    )

                    Button(
                        onClick = { /* 클릭 동작 */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFA500), // 주황색 (오렌지색)
                            contentColor = Color.White // 하얀색 텍스트
                        ),
                        modifier = Modifier
                            .padding(top = 8.dp,bottom = 8.dp)
                            .align(Alignment.CenterHorizontally) // 버튼 수평 중앙 정렬
                    ) {
                        Text("완료 하기")
                    }
                }
            } //Surface
        } //Column
    }
} //LoginScreen