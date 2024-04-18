package jp.co.yumemi.droidtraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import jp.co.yumemi.droidtraining.ui.theme.AndroidPracticeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    WeatherLayout()
                }
            }
        }
    }
}

@Composable
fun WeatherLayout() {
    BoxWithConstraints {
        val imagesHalfWidth = maxWidth / 2

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (images, buttons) = createRefs()
            Column(
                modifier = Modifier
                    .width(imagesHalfWidth)
                    .constrainAs(images) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.droidkun),
                    contentDescription = "droid",
                    modifier = Modifier.aspectRatio(1f / 1f),
                )
                Temperature(modifier = Modifier.fillMaxWidth())
            }
            RowButtons(
                modifier = Modifier.constrainAs(buttons) {
                    val margin = 80.dp
                    top.linkTo(images.bottom, margin = margin)
                    start.linkTo(images.start)
                    end.linkTo(images.end)
                    width = Dimension.fillToConstraints
                }
            )
        }
    }
}

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

@Composable
fun RowButtons(modifier: Modifier = Modifier) {
    val reload = stringResource(id = R.string.reload)
    val next = stringResource(id = R.string.next)
    Row(modifier = modifier) {
        Button(
            modifier = Modifier.weight(1f),
            onClick = {},
            colors = ButtonDefaults.textButtonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(5.dp),
        ) {
            Text(text = reload, color = Color.White)
        }
        Spacer(modifier = modifier.padding(9.dp))
        Button(
            modifier = Modifier.weight(1f),
            onClick = {},
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Black
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            Text(text = next, color = Color.White)
        }
    }
}

@Preview
@Composable
fun WeatherLayoutPreview() {
    Surface {
        WeatherLayout()
    }
}
