package com.example.rebonesw.ui.screen.screeningtest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebonesw.data.navigation.ScreeningTestDestination
import androidx.compose.foundation.layout.Row as Row

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreeningTestScreen01(
    moveScreen: (ScreeningTestDestination) -> Unit
) {
    var selectedOption by remember { mutableStateOf<Int?>(null) }

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
                    IconButton(onClick = {  }) {
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
                    text = "1. 무게 4.5kg을 들어서 나르는 것이 얼마나 어려운가요?",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                RadioButtonGroup(
                    options = listOf("전혀 어렵지 않다.", "조금 어렵다.", "매우 어렵다/할 수 없다."),
                    selectedOption = selectedOption,
                    onOptionSelected = { selectedOption = it},
                    moveScreenG = moveScreen
                )
            }
        }
    )
} //fun ScreeningTestScreen01

@Composable
fun RadioButtonGroup(
    options: List<String>,
    selectedOption: Int?,
    onOptionSelected: (Int) -> Unit,
    moveScreenG: (ScreeningTestDestination) -> Unit
) {
    Column {
        options.forEachIndexed { index, option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                RadioButton(
                    selected = selectedOption == index,
                    onClick = {
                        onOptionSelected(index)
                        moveScreenG(ScreeningTestDestination.SurveyScreen02)
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
fun PreviewSarcFQuestionScreen() {
    ScreeningTestScreen01( moveScreen = {})
}
