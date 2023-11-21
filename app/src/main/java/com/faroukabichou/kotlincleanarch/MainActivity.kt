package com.faroukabichou.kotlincleanarch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.faroukabichou.kotlincleanarch.core.navigation.MainNavGraph
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            KcTheme {
                MainNavGraph(
                    navController = navController
                )
            }
        }
    }
}