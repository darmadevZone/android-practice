package jp.co.yumemi.droidtraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import jp.co.yumemi.api.YumemiWeather
import jp.co.yumemi.droidtraining.presentation.components.RowButtons
import jp.co.yumemi.droidtraining.presentation.components.Temperature
import jp.co.yumemi.droidtraining.presentation.constant.Image.ImageConstants
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
    val context = LocalContext.current
    var weather by remember {
        mutableStateOf("")
    }
    BoxWithConstraints {
        val imagesHalfWidth = maxWidth / 2

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (images, buttons) = createRefs()
            Column(modifier = Modifier
                .width(imagesHalfWidth)
                .constrainAs(images) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }) {
                WeatherContent(weather = weather)
                Temperature(modifier = Modifier.fillMaxWidth())
            }
            RowButtons(modifier = Modifier.constrainAs(buttons) {
                val margin = 80.dp
                top.linkTo(images.bottom, margin = margin)
                start.linkTo(images.start)
                end.linkTo(images.end)
                width = Dimension.fillToConstraints
            },
                onNextClick = {/* TODO */ },
                onReloadClick = {
                    val response = YumemiWeather(context = context).fetchSimpleWeather()
                    Log.d("response", response)
                    weather = response
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

        else -> {
            //defaultでは、sunny
            ImageConstants.sunny
        }
    }

    Image(
        modifier = Modifier.aspectRatio(1f / 1f),
        painter = painterResource(weatherInfo),
        contentDescription = "droid",
    )
}

@Preview
@Composable
fun SomeLayoutPreview() {
    Surface {
        SomeLayout()
    }
}
