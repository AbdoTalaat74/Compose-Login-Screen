package com.example.composeloginscreeninit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composeloginscreeninit.ui.theme.ComposeLoginScreenInitTheme
import com.example.composeloginscreeninit.ui.theme.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLoginScreenInitTheme {
                LoginScreen()

            }
        }
    }
}
