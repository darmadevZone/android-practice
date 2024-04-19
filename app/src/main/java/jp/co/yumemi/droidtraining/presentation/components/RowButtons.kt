package jp.co.yumemi.droidtraining.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import jp.co.yumemi.droidtraining.R

@Composable
fun RowButtons(
    modifier: Modifier = Modifier,
    onReloadClick: () -> Unit,
    onNextClick: () -> Unit
) {
    val reload = stringResource(id = R.string.reload)
    val next = stringResource(id = R.string.next)
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(18.dp)) {
        Button(
            onClick = onReloadClick,
            shape = CutCornerShape(5.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Black
            ),
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = reload, color = Color.White)
        }
        Button(
            onClick = onNextClick,
            shape = CutCornerShape(5.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Black
            ),
            modifier = Modifier.weight(1f),
        ) {
            Text(text = next, color = Color.White)
        }
    }
}
