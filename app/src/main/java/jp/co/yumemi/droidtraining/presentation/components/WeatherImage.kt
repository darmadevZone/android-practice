package jp.co.yumemi.droidtraining.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import jp.co.yumemi.droidtraining.presentation.constant.image.ImageConstants

@Composable
fun WeatherImage(weather: String) {
    val weatherInfo = ImageConstants.fromString(weather) ?: ImageConstants.Sunny

    Image(
        modifier = Modifier.aspectRatio(1f / 1f),
        painter = painterResource(weatherInfo.response),
        contentDescription = "droid",
    )
}
