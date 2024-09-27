package com.example.rebonesw.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.rebonesw.data.RegisterData
import com.example.rebonesw.data.navigation.RegisterDestination
import com.example.rebonesw.ui.screen.register.RegisterCompletedScreen
import com.example.rebonesw.ui.screen.register.RegisterScreen
import com.example.rebonesw.ui.theme.ReboneSWTheme
import com.example.rebonesw.viewmodels.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class RegisterActivity: ComponentActivity() {
    private val vm:RegisterViewModel by viewModels()

    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            ReboneSWTheme {
                // Composable에서 상태를 직접 관찰하고 리컴포지션 발생
                val navDestinationProperties by vm.navDestination.collectAsState()

                when(navDestinationProperties){
                    RegisterDestination.RegisterScreen -> RegisterScreen(
                        onRegister,
                        vm
                    )

                    RegisterDestination.RegisterCompletedScreen -> {
                        RegisterCompletedScreen()
                        LaunchedEffect(Unit) {
                            // 2초 대기 후 메인 페이지로 이동
                            delay(2000)
                            startActivity(Intent(this@RegisterActivity, OnboardingActivity::class.java))
                            finish() // 현재 액티비티 종료
                        }
                    }
                }


            } //ReboneSWTheme
        } //setContent
    } //onCreate

    private val onRegister: (registerData:RegisterData) -> Unit = { data ->
        vm.updateRegister(data)
        vm.updateNavDestination(RegisterDestination.RegisterCompletedScreen) // 화면 전환
    }

} //RegisterActivity