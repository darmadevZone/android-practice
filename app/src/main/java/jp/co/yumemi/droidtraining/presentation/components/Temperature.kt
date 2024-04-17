package jp.co.yumemi.droidtraining.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import jp.co.yumemi.droidtraining.R

@Composable
fun Temperature(modifier: Modifier = Modifier) {
    val maxText = stringResource(id = R.string.max)
    val minText = stringResource(id = R.string.min)
    Row(modifier = modifier) {
        Text(
            text = minText, modifier = Modifier.weight(1f), textAlign = TextAlign.Center
        )
        Text(
            text = maxText, modifier = Modifier.weight(1f), textAlign = TextAlign.Center
        )
    }
}
