package com.example.rebonesw.ui.screen.screeningtest

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebonesw.data.ScreeningTestAnswersData
import com.example.rebonesw.data.navigation.ScreeningTestDestination
import com.example.rebonesw.viewmodels.ScreeningTestViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScreeningTestInfoScreen(
    vm: ScreeningTestViewModel,
    completeAnswers: () -> Unit
    ) {
    val pagerState = rememberPagerState(pageCount = { 6 }, initialPage = 0)
    val scope = rememberCoroutineScope()
    var answers by remember { mutableStateOf(ScreeningTestAnswersData()) }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) {
        when (it) {
            0 -> InfoTextScreen(
                onStartClicked = {
                    scope.launch {
                        pagerState.animateScrollToPage(1) // 시작하기 버튼 누르면 첫 번째 질문 페이지로 이동
                    }
                })
            in 1..5 -> ScreeningTestScreen(
                page = it,
                isLastPage = it == 5,
                onNextPage = {
                    scope.launch {
                        pagerState.animateScrollToPage(it + 1) // 다음 페이지로 이동
                    }
                },
                onBackPage = {
                    scope.launch {
                        pagerState.animateScrollToPage(it - 1) // 이전 페이지로 이동
                    }
                },
                answers = answers,
                onUpdateAnswers = { updatedAnswers -> answers = updatedAnswers },
                vm = vm,
                completeAnswers = completeAnswers
            )
        }
    }
} //fun ScreeningTestInfoScreen

@Composable
fun InfoTextScreen(
    onStartClicked: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // 수평 가운데 정렬
    ) {


        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 128.dp, start = 32.dp, end = 32.dp),
            horizontalAlignment = Alignment.Start // 텍스트를 좌측 정렬
        ) {
            Text(
                text = "SARC-F 검사",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = buildAnnotatedString {
                    append("근감소증 자가진단 설문지(SARC-F)는")
                    withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)) {
                        append(" 총 5개의 문항으로 근력, 보행 속도, 일상 활동, 의장에서 일어나는 능력, 낙상 빈도를 평가")
                    }
                    append("합니다.\n\n총 10점 중 4점 이상이면 근감소증을 의심할 수 있습니다.\n\n각 항목에 답변한 내용을 바탕으로 근감소증 의심 환자를 선별하기 때문에 솔직하게 답변해 주세요!👍")
                },
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
        Button(
            onClick = {
                onStartClicked()
            },
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF15B5B),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50) // 버튼 모서리를 둥글게 설정
        ) {
            Text(text = "시작하기", fontSize = 18.sp)
        }
    }
} //private fun InfoTextScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreeningTestScreen(
    page: Int,
    isLastPage: Boolean,
    onNextPage: () -> Unit,
    onBackPage: () -> Unit,
    answers : ScreeningTestAnswersData,
    onUpdateAnswers: (ScreeningTestAnswersData) -> Unit, // 상위 컴포저블로 answers 업데이트 전달
    vm: ScreeningTestViewModel,
    completeAnswers: () -> Unit
){
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    val context = LocalContext.current
    val questions = listOf(
        "1. 무게 4.5kg을 들어서 나르는 것이 얼마나 어려운가요?",
        "2. 방안 한 쪽 끝에서 다른 쪽 끝까지 걷는 것이 얼마나 어려운가요?",
        "3. 의자에서 일어나 침대로, 혹은 침대에서 일어나 의자로 이동하는 것이 얼마나 어려운가요?",
        "4. 10개의 계단을 쉬지 않고 오르는 것이 얼마나 어려운가요? ",
        "5. 지난 1년 동안 몇 번이나 넘어지셨나요? (넘어지지 않도록 조심하면서 일상생활을 하는 것이 어려운가요?)"
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "SARC-F")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPage() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = questions[page - 1],
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp)
                )

                RadioButtonGroup(
                    options = listOf("전혀 어렵지 않다.", "조금 어렵다.", "매우 어렵다/할 수 없다."),
                    selectedOption = selectedOption,
                    onOptionSelected = {
                        selectedOption = it
                        Log.d("selectedOption", "selectedOption" + selectedOption.toString())
                        Log.d("selectedOption", "page" + page.toString())
                        val a = when(page){
                            1 -> answers.copy(stAnswers01 = it)
                            2 -> answers.copy(stAnswers02 = it)
                            3 -> answers.copy(stAnswers03 = it)
                            4 -> answers.copy(stAnswers04 = it)
                            5 -> answers.copy(stAnswers05 = it)
                            else -> answers
                        }
                        onUpdateAnswers(a)
                        onNextPage()
                    },
                )

                Spacer(modifier = Modifier.height(32.dp))

                if (isLastPage) {
                    Button(
                        onClick = { /*제출하기 버튼*/
                            if (answers.stAnswers05 == -1){
                                Toast.makeText(context, "모든 항목에 답변해주세요.", Toast.LENGTH_SHORT).show()
                            }else {
                                vm.updateScreeningTestAnswers(answers)
                                completeAnswers()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF15B5B),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text(text = "제출하기", fontSize = 18.sp)
                    }
                }
            }
        }
    )
} //fun ScreeningTestScreen

@Composable
fun RadioButtonGroup(
    options: List<String>,
    selectedOption: Int?,
    onOptionSelected: (Int) -> Unit,
) {
    Column {
        options.forEachIndexed { index, option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onOptionSelected(index) }
            ) {
                RadioButton(
                    selected = selectedOption == index,
                    onClick = {
                        onOptionSelected(index)
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color(0xFFF15B5B),
                        unselectedColor = Color(0xFFF15B5B)
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option, fontSize = 16.sp)
            }
        }
    }
} //fun RadioButtonGroup

@Preview(showBackground = true)
@Composable
fun PreviewScreeningTestInfo() {
//    ScreeningTestInfoScreen()
}
