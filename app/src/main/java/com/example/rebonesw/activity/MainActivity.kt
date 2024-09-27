package com.example.rebonesw.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rebonesw.ui.theme.ReboneSWTheme
import com.example.rebonesw.viewmodels.MainViewMdoel

class MainActivity : ComponentActivity() {
    private val vm: MainViewMdoel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReboneSWTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Main",
                        modifier = Modifier.padding(innerPadding)
                    )
                } //Scaffold
            } // ReboneSWTheme
        } //setContent

    } //fun OnCreate

} //class MainActivity

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
