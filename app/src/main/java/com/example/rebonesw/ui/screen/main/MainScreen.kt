package com.example.rebonesw.ui.screen.main

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawResult
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebonesw.R
import com.example.rebonesw.viewmodels.MainViewMdoel

@Composable
fun MainScreen(
    modifier: Modifier,
    vm: MainViewMdoel,
    sumsAnswersData: Int,
    moveScreenTestInfo: () -> Unit
) {
    Log.d("MainScreen", "sumsAnswersData: $sumsAnswersData")
    // 리컴포지셔블 고려해서
    val sumsAnswersData = vm.screeningTestAnswersData?.let { data ->
        with(data) {
            stAnswers01 + stAnswers02 + stAnswers03 + stAnswers04 + stAnswers05
        }
    } ?: -1 // null일 경우 0으로 처리

    val resultSARCF = when {
        sumsAnswersData == -1 -> "설문조사 필요"
        sumsAnswersData in 0..3 -> "정상 소견"
        sumsAnswersData >= 4 -> "근감소증 의심군"
        else -> "알 수 없음"
    }
    var state0 = 0
    var state1 = 1
    var state2 = 2

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp)
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                // 참여자 환영문
                Text(
                    text = buildAnnotatedString {
                        append("안녕하세요 ")
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFFF15B5B),
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("${vm.registerData?.userName}")
                        }
                        append("님\uD83D\uDE0A")
                    },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }

        item { Spacer(modifier = Modifier.height(30.dp)) }

        item {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .heightIn( max = 150.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // 검사 진행 현황
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(16.dp))
                        .weight(0.4f)
                        .background(Color(0xFFFBEAEA))
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(), // Column의 높이를 채움
                        verticalArrangement = Arrangement.SpaceBetween // 텍스트를 위와 아래에 배치
                    ) {
                        Text(
                            text = "검사 진행 현황",
                            color = Color.Black
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "0",
                                fontSize = 56.sp,
                                color = Color(0xFFF15B5B)
                            )
                            Text(
                                text = " 개 완료",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        }

                    }
                }

                Spacer(modifier=Modifier.width(8.dp))

                // SARC-F 결과
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(16.dp))
                        .weight(0.6f)
                        .background(Color(0xFFFFF3CD))
                        .padding(16.dp)
                        .clickable {
                            moveScreenTestInfo()
                        }
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(), // Column의 높이를 채움
                        verticalArrangement = Arrangement.SpaceBetween // 텍스트를 위와 아래에 배치
                    ) {
                        Text(
                            text = "SARC-F 결과",
                            color = Color.Black
                        )
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color(0xFFF15B5B),
                                        fontWeight = FontWeight.Bold
                                    )
                                ){
                                    append(resultSARCF)
                                }
                                append("\n대상자입니다.")
                            },
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }
                }
            } // Row
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            // 근감소증 검사 항목 텍스트
            Text(
                text = "근감소증 검사 항목",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 18.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.padding( end = 8.dp),
                    painter = painterResource( id = R.drawable.group),
                    contentDescription = "exclamation mark",
                )
                Text(
                    text = "아래 5가지 검사를 차례대로 진행합니다.",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

        }
        item { Spacer(modifier = Modifier.height(8.dp)) }

        item {
            // 검사 항목 리스트
            TestItemBox(text = "신속태핑 검사", 0 , 0)
            TestItemBox(text = "팔 굽히기 검사",1 , state1)
            TestItemBox(text = "앉았다 일어나기 검사",2 , state2)
            TestItemBox(text = "한발 서기 검사",3 , 1)
            TestItemBox(text = "일어서서 걷기 검사",4 , 1)
        }

    } //Column
} //MainScreen

@Composable
fun TestItemBox(text: String, scareeningtextNumb: Int, state: Int) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .clickable { startTest(text, scareeningtextNumb, context) }
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .shadow(4.dp, shape = RoundedCornerShape(8.dp)) // 그림자 추가
            .background(Color.White, shape = RoundedCornerShape(8.dp))
//            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp)) //테두리
            .padding(16.dp)
            .height(32.dp),
        contentAlignment = Alignment.Center // 텍스트를 중앙에 배치
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )

            when (state){
                0-> {
                    Box(
                        modifier = Modifier
                            .clickable { startTest(text, scareeningtextNumb, context) }
                            .border(1.dp, Color(0xFFF15B5B), RoundedCornerShape(50)) // 둥근 외곽선
                            .padding(horizontal = 24.dp, vertical = 4.dp) // 텍스트 패딩
                        ,
                        contentAlignment = Alignment.Center // 텍스트를 중앙에 배치
                    ) {
                        Text(
                            text = "시작하기",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF15B5B),
                            fontSize = 12.sp
                        )
                    }
                }
                1 -> {
                    Box(
                        modifier = Modifier
                            .clickable {
                                startTest(text, scareeningtextNumb, context)
                            }
                            .widthIn(96.dp),

                        contentAlignment = Alignment.Center // 텍스트를 중앙에 배치
                    ) {
                        Icon(Icons.Default.Lock, contentDescription = null, tint = Color(0xFFF15B5B))
                    }
                }
                2 -> {
                    Box(
                        modifier = Modifier
                            .clickable {
                                startTest(text, scareeningtextNumb, context)
                            }
                            .widthIn(96.dp),

                        contentAlignment = Alignment.Center // 텍스트를 중앙에 배치
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = Color(0xFFF15B5B))
                    }
                }
            } //when
        } //Row
    } //Box
} //TestItemBox

private fun startTest(text: String, scareeningtextNumb: Int) {}
private fun startTest(text: String, scareeningtextNumb: Int, context: Context) {
    Toast.makeText(context, "${text} $scareeningtextNumb 선행 검사를 진행해주세요", Toast.LENGTH_SHORT).show()
}

private fun sumsAnswersData(){

}