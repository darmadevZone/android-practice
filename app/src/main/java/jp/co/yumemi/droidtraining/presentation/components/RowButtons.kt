package jp.co.yumemi.droidtraining.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import jp.co.yumemi.droidtraining.R

@Composable
fun RowButtons(
    onNextClick: () -> Unit,
    onReloadClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val reload = stringResource(id = R.string.reload)
    val next = stringResource(id = R.string.next)
    Row(modifier = modifier) {
        Button(
            modifier = Modifier.weight(1f),
            onClick = onReloadClick,
            colors = ButtonDefaults.textButtonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(5.dp),
        ) {
            Text(text = reload, color = Color.White)
        }
        Spacer(modifier = modifier.padding(9.dp))
        Button(
            modifier = Modifier.weight(1f),
            onClick = onNextClick,
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Black
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            Text(text = next, color = Color.White)
        }
    }
}
