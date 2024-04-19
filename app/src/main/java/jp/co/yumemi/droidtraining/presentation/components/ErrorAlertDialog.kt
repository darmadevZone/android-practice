package jp.co.yumemi.droidtraining.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun ErrorAlertDialog(
    onReloadClick: () -> Unit,
    onCloseClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        confirmButton = {
            Row {
                TextButton(onClick = onCloseClick) {
                    Text(text = "Close")
                }
                TextButton(onClick = onReloadClick) {
                    Text(text = "Reload")
                }
            }
        },
        title = {
            Text(text = "Error")
        },
        text = {
            Text(text = "エラーが発生しました")
        },
    )
}
