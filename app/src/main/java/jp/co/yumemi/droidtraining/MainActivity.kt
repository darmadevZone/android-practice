package jp.co.yumemi.droidtraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.droidtraining.presentation.components.ErrorAlertDialog
import jp.co.yumemi.droidtraining.presentation.constant.image.ImageConstants
import jp.co.yumemi.droidtraining.presentation.screen.WeatherScreen
import jp.co.yumemi.droidtraining.presentation.state.WeatherState
import jp.co.yumemi.droidtraining.presentation.viewmodel.WeatherViewModel
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
                    val viewModel = remember {
                        WeatherViewModel()
                    }
                    val context = LocalContext.current
                    LaunchedEffect(Unit) {
                        viewModel.getWeather(context)
                    }
                    when (val weatherState = viewModel.weatherState.value) {
                        is WeatherState.Success -> {
                            WeatherScreen(
                                onReloadClick = {
                                    viewModel.getWeather(context)
                                },
                                onNextClick = {},
                                weather = weatherState.weather
                            )
                        }

                        is WeatherState.Error -> {
                            ErrorAlertDialog(
                                onCloseClick = {},
                                onReloadClick = {
                                    viewModel.getWeather(context)
                                },
                            )
                        }

                        is WeatherState.Loading -> {
                            Box(contentAlignment = Alignment.Center) {
                                CircularProgressIndicator()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun WeatherPreview() {
    Surface {
        WeatherScreen(onNextClick = {}, onReloadClick = {}, weather = ImageConstants.Sunny.weather)
    }
}
