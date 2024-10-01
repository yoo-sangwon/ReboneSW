package com.example.rebonesw.ui.screen.register

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.rebonesw.R
import com.example.rebonesw.data.RegisterData
import com.example.rebonesw.viewmodels.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onRegister: (RegisterData) -> Unit,
    vm: RegisterViewModel
){
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var connectNumber by remember { mutableStateOf("") }
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current //Compose에서 포커스를 관리하는 객체

    val ageTextFieldRequester = remember { FocusRequester() }
    val connectNumberTextFieldRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { focusManager.clearFocus() },
        contentAlignment = Alignment.Center
    ){
        Column(

        ) {
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(bottom = 32.dp) // 이미지 수평 중앙 정렬
                    ,
                painter = painterResource(id = R.drawable.rebone_logo),
                contentDescription = null,
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
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)), // 둥근 모서리의 검정 테두리 추가
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent
                        ),
                        value = name,
                        onValueChange = { inputName -> name = inputName },
                        singleLine = true,
                        keyboardActions = KeyboardActions(
                            onDone = {
                                ageTextFieldRequester.requestFocus()
                            }
                        )
                    )

                    // 나이 입력 필드 (숫자만 입력받도록 처리)
                    Text(
                        modifier = Modifier.padding(top = 8.dp,bottom = 8.dp),
                        text = "나이"
                    )
                    TextField(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))  // 둥근 모서리의 검정 테두리 추가
                            .focusRequester(ageTextFieldRequester),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent
                        ),
                        value = age,
                        onValueChange = { inputAge ->
                            // 숫자만 입력받기 위한 로직
                            if (inputAge.all { it.isDigit() }) {
                                age = inputAge
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number, // 숫자 키보드 타입 설정
                        ),
                        singleLine = true,
                        keyboardActions = KeyboardActions(
                            onDone = {
                                connectNumberTextFieldRequester.requestFocus()
                            }
                        )
                    )

                    // 전화번호 입력 필드 (숫자만 입력받도록 처리)
                    Text(
                        modifier = Modifier.padding(top = 8.dp,bottom = 8.dp),
                        text = "전화번호"
                    )
                    TextField(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)) // 둥근 모서리의 검정 테두리 추가
                            .focusRequester(connectNumberTextFieldRequester),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent
                        ),
                        value = connectNumber,
                        onValueChange = { inputNumber ->
                            // 숫자만 입력받기 위한 로직
                            if (inputNumber.all { it.isDigit() }) {
                                connectNumber = inputNumber
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number, // 숫자 키보드 타입 설정
                        ),
                        singleLine = true,
                        keyboardActions = KeyboardActions(
                            onDone = {
                                focusManager.clearFocus()
                            }
                        )
                    )

                    Button(
                        onClick = {
                            // 모든 값이 비어있지 않을 때 Activity 이동
                            if (name.isNotBlank() && age.isNotBlank() && connectNumber.isNotBlank()) {

                                var registerData = RegisterData(
                                    userId = 0,
                                    userName = name,
                                    userAge = age,
                                    userPhoneNumber = connectNumber,
                                    userState = 0 ,
                                )
                                onRegister(registerData)
//                                Toast.makeText(context, "등록 완료", Toast.LENGTH_SHORT).show()
                            } else {
                                // 값이 비어있는 경우 처리 (예: 토스트 메시지)
                                 Toast.makeText(context, "모든 필드를 채워주세요.", Toast.LENGTH_SHORT).show()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF15B5B), // 피그마에서 색상 찾음
                            contentColor = Color.White // 하얀색 텍스트
                        ),
                        modifier = Modifier
                            .padding(top = 16.dp,bottom = 16.dp)
                            .align(Alignment.CenterHorizontally) // 버튼 수평 중앙 정렬
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 32.dp, end = 32.dp),
                            text = "완료 하기")
                    }
                }
            } //Surface
        } //Column
    }
} //LoginScreen