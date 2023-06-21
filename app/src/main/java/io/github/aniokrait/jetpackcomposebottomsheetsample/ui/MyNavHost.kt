package io.github.aniokrait.jetpackcomposebottomsheetsample.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.github.aniokrait.jetpackcomposebottomsheetsample.data.Screen
import io.github.aniokrait.jetpackcomposebottomsheetsample.ui.screen.FriendsListScreen
import io.github.aniokrait.jetpackcomposebottomsheetsample.ui.screen.ProfileScreen
import io.github.aniokrait.jetpackcomposebottomsheetsample.ui.screen.SettingScreen

@Composable
fun MyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "profile"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.ProfileScreen.route) {
            ProfileScreen()
        }
        composable(Screen.FriendsListScreen.route) {
            FriendsListScreen()
        }
        composable(Screen.SettingScreen.route) {
            SettingScreen()
        }
    }
}