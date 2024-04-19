import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import jp.co.yumemi.droidtraining.presentation.components.BoxContentLayout
import jp.co.yumemi.droidtraining.presentation.components.ErrorAlertDialog
import jp.co.yumemi.droidtraining.presentation.state.WeatherState
import jp.co.yumemi.droidtraining.presentation.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = viewModel()
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.getWeather(context)
    }
    when (val weatherState = viewModel.weatherState.value) {
        is WeatherState.Success -> {
            BoxContentLayout(
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
