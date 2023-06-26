package io.github.aniokrait.jetpackcomposebottomsheetsample.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.aniokrait.jetpackcomposebottomsheetsample.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    var skipPartiallyExpanded by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded
    )

    //親画面のコンテンツ
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "主画面のコンテンツ")
        Button(onClick = {
            scope.launch {
                openBottomSheet = true
            }
        }) {
            Text(text = "ボトムシートを開く")
        }
    }
    //ここからボトムシートのコンテンツ
    if (openBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.padding(top = 16.dp),
            onDismissRequest = {openBottomSheet = false },
            sheetState = bottomSheetState,
        ) {
            Column(
                modifier = Modifier.padding(start = 16.dp, bottom = 24.dp)
            ) {
                BottomSheetIconTextRow(icon = R.drawable.baseline_share_24, text = "Share")
                BottomSheetIconTextRow(icon = R.drawable.baseline_link_24, text = "Get link")
                BottomSheetIconTextRow(icon = R.drawable.baseline_edit_24, text = "Edit name")
                BottomSheetIconTextRow(icon = R.drawable.baseline_delete_24, text = "Delete collection")
            }
        }
    }

}

