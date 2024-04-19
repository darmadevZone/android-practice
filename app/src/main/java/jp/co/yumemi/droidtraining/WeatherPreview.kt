package jp.co.yumemi.droidtraining

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.droidtraining.presentation.components.BoxContentLayout
import jp.co.yumemi.droidtraining.presentation.constant.image.ImageConstants

@Preview
@Composable
fun SunnyPreview() {
    Surface {
        BoxContentLayout(
            onNextClick = {},
            onReloadClick = {},
            weather = ImageConstants.Sunny.weather
        )
    }
}

@Preview
@Composable
fun CloudyPreview() {
    Surface {
        BoxContentLayout(
            onNextClick = {},
            onReloadClick = {},
            weather = ImageConstants.Cloudy.weather
        )
    }
}

@Preview
@Composable
fun RainyPreview() {
    Surface {
        BoxContentLayout(
            onNextClick = {},
            onReloadClick = {},
            weather = ImageConstants.Rainy.weather
        )
    }
}

@Preview
@Composable
fun SnowPreview() {
    Surface {
        BoxContentLayout(
            onNextClick = {},
            onReloadClick = {},
            weather = ImageConstants.Snow.weather
        )
    }
}
