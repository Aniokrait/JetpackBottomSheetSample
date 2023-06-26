package io.github.aniokrait.jetpackcomposebottomsheetsample.ui.organism

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import io.github.aniokrait.jetpackcomposebottomsheetsample.R
import io.github.aniokrait.jetpackcomposebottomsheetsample.ui.screen.BottomSheetCategory
import io.github.aniokrait.jetpackcomposebottomsheetsample.ui.screen.BottomSheetIconTextRow

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SharedBottomSheet(sheetState: ModalBottomSheetState,
    screen: @Composable () -> Unit
) {
    ModalBottomSheetLayout(
        modifier = Modifier.zIndex(100F),
        sheetElevation = 60.dp,
        sheetState = sheetState,
        sheetContent = {
            var sheetCategory = BottomSheetCategory.SHEET_A
            Column {
                when(sheetCategory) {
                    BottomSheetCategory.SHEET_A -> {
                        //ボタンAに対応したボトムシートを表示
                        BottomSheetIconTextRow(icon = R.drawable.baseline_share_24, text = "Share")
                        BottomSheetIconTextRow(icon = R.drawable.baseline_link_24, text = "Get link")
                        BottomSheetIconTextRow(icon = R.drawable.baseline_edit_24, text = "Edit name")
                        BottomSheetIconTextRow(icon = R.drawable.baseline_delete_24, text = "Delete collection")
                    }
                    BottomSheetCategory.SHEET_B -> {
                        //ボタンBに対応したボトムシートを表示
                    }
                }

            }
        }
    ) {
        screen()
    }
}