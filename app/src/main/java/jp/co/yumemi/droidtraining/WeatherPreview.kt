package jp.co.yumemi.droidtraining

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.droidtraining.presentation.constant.image.ImageConstants
import jp.co.yumemi.droidtraining.presentation.screen.WeatherScreen

@Preview
@Composable
fun SunnyPreview() {
    Surface {
        WeatherScreen(onNextClick = {}, onReloadClick = {}, weather = ImageConstants.Sunny.weather)
    }
}

@Preview
@Composable
fun CloudyPreview() {
    Surface {
        WeatherScreen(onNextClick = {}, onReloadClick = {}, weather = ImageConstants.Cloudy.weather)
    }
}

@Preview
@Composable
fun RainyPreview() {
    Surface {
        WeatherScreen(onNextClick = {}, onReloadClick = {}, weather = ImageConstants.Rainy.weather)
    }
}

@Preview
@Composable
fun SnowPreview() {
    Surface {
        WeatherScreen(onNextClick = {}, onReloadClick = {}, weather = ImageConstants.Snow.weather)
    }
}
