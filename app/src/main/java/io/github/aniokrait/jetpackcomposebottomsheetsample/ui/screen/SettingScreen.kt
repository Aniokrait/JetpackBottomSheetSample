package io.github.aniokrait.jetpackcomposebottomsheetsample.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import io.github.aniokrait.jetpackcomposebottomsheetsample.ui.organism.SharedBottomSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingScreen() {
    var skipHalfExpanded by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = skipHalfExpanded
    )
    val scope = rememberCoroutineScope()
    SharedBottomSheet(
        sheetState = sheetState
    ) {
        Column() {
            Text(text = "共通のボトムシートを使用している画面")
            Button(onClick = {
                scope.launch {
                    sheetState.show()
                }
            }) {
                Text(text = "ボトムシートを開く")
            }
        }
    }
}