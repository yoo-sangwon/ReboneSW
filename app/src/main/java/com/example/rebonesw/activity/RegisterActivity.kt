package com.example.rebonesw.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.rebonesw.data.RegisterData
import com.example.rebonesw.ui.screen.register.RegisterScreen
import com.example.rebonesw.ui.theme.ReboneSWTheme
import com.example.rebonesw.viewmodels.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity: ComponentActivity() {
    private val vm:RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            ReboneSWTheme {
                RegisterScreen(
                    onRegister,
                    vm
                )
            } //ReboneSWTheme
        } //setContent
    } //onCreate

    private val onRegister: (registerData:RegisterData) -> Unit = { data ->
        vm.updateRegister(data)
    }

} //RegisterActivity