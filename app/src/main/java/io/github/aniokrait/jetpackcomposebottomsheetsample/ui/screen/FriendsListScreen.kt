package io.github.aniokrait.jetpackcomposebottomsheetsample.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun FriendsListScreen() {
    var skipHalfExpanded by remember { mutableStateOf(false) }
    val state = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = skipHalfExpanded
    )
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        modifier = Modifier.zIndex(100F),
        sheetElevation = 60.dp,
        sheetState = state,
        sheetContent = {
//            //ボトムシート内に表示するコンテンツ
//            Column(
//                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 8.dp),
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                BottomSheetIconTextRow(icon = R.drawable.baseline_share_24, text = "Share")
//                BottomSheetIconTextRow(icon = R.drawable.baseline_link_24, text = "Get link")
//                BottomSheetIconTextRow(icon = R.drawable.baseline_edit_24, text = "Edit name")
//                BottomSheetIconTextRow(icon = R.drawable.baseline_delete_24, text = "Delete collection")
//            }
            var sheetCategory = BottomSheetCategory.SHEET_A
            Column {
                when(sheetCategory) {
                    BottomSheetCategory.SHEET_A -> {
                        //ボタンAに対応したボトムシートを表示
                    }
                    BottomSheetCategory.SHEET_B -> {
                        //ボタンBに対応したボトムシートを表示
                    }
                }

            }
        }
    ) {
        //ボトムシートを開く画面はModalBottomSheetLayoutでラップする必要があった。
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "主画面のコンテンツ")
            Button(
                modifier = Modifier.padding(bottom = 16.dp),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.Gray,
                    contentColor = Color.White
                ),
                onClick = { scope.launch { state.show() } }) {
                Text("ボトムシートを開く")
            }
        }
    }
}

@Composable
fun BottomSheetIconTextRow(@DrawableRes icon: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painterResource(icon), text, tint = Color.Gray)
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = text,
            fontSize = 24.sp,
        )
    }

}

enum class BottomSheetCategory{
    SHEET_A,
    SHEET_B
}