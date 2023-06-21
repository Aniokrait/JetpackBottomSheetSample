package io.github.aniokrait.jetpackcomposebottomsheetsample.data

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.aniokrait.jetpackcomposebottomsheetsample.R

sealed class Screen (
    val order: Int,
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector,
    val contentDescription: String
) {
    object ProfileScreen: Screen(1, "profile", R.string.profile, Icons.Filled.Face, "プロフィール")
    object FriendsListScreen: Screen(2, "friendslist", R.string.friends_list, Icons.Filled.Share, "フレンドリスト")
    object SettingScreen: Screen(3, "setting", R.string.setting, Icons.Filled.Settings, "設定")
}
