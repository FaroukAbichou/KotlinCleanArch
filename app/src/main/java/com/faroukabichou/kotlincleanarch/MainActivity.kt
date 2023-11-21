package com.faroukabichou.kotlincleanarch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.faroukabichou.kotlincleanarch.core.di.initKoin
import com.faroukabichou.kotlincleanarch.core.navigation.MainNavGraph
import com.faroukabichou.kotlincleanarch.core.theme.KcTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.stopKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initKoin {
            androidContext(applicationContext)
        }

        setContent {
            val navController = rememberNavController()
            KcTheme {
                MainNavGraph(navController = navController)
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}