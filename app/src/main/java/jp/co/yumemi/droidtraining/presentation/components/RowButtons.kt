package jp.co.yumemi.droidtraining.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import jp.co.yumemi.droidtraining.R

@Composable
fun RowButtons(
    modifier: Modifier = Modifier, onReloadClick: () -> Unit, onNextClick: () -> Unit
) {
    val reload = stringResource(id = R.string.reload)
    val next = stringResource(id = R.string.next)
    val context = LocalContext.current
    Row(modifier = modifier) {
        Button(modifier = Modifier.weight(1f), onClick = onReloadClick) {
            Text(text = reload)
        }
        Button(modifier = Modifier.weight(1f), onClick = onNextClick) {
            Text(text = next)
        }
    }
}
