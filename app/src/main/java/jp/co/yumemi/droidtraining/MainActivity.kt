package jp.co.yumemi.droidtraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                    Box(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        SomeLayout()
                    }
                }
            }
        }
    }
}


@Composable
fun SomeLayout() {
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
                    modifier = Modifier.aspectRatio(1f / 1f),
                    painter = painterResource(id = R.drawable.droidkun),
                    contentDescription = "droid"
                )
                Temperature(modifier = Modifier.fillMaxWidth())
            }
            RowButtons(modifier = Modifier.constrainAs(buttons) {
                val margin = 80.dp
                top.linkTo(images.bottom, margin = margin)
                start.linkTo(images.start)
                end.linkTo(images.end)
                width = Dimension.fillToConstraints
            })
        }
    }
}

@Composable
fun WeatherContent(weather: String) {
    val weatherInfo = when (weather) {
        "sunny" -> {
            ImageConstants.sunny
        }

        "snow" -> {
            ImageConstants.snow
        }

        "rainy" -> {
            ImageConstants.rainy
        }

        "cloudy" -> {
            ImageConstants.cloudy
        }
        Button(modifier = Modifier.weight(1f), onClick = {}) {
            Text(text = next)
        }
    }
}

@Preview
@Composable
fun SomeLayoutPreview() {
    Surface {
        SomeLayout()
    }
}
