package io.github.aniokrait.jetpackcomposebottomsheetsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import io.github.aniokrait.jetpackcomposebottomsheetsample.ui.MyBottomNavigation
import io.github.aniokrait.jetpackcomposebottomsheetsample.ui.MyNavHost
import io.github.aniokrait.jetpackcomposebottomsheetsample.ui.theme.JetpackComposeBottomSheetSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBottomSheetSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = { MyBottomNavigation(navController = navController) }
                    ) { innerPadding ->
                        MyNavHost(
                            modifier = Modifier.padding(innerPadding),
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}


