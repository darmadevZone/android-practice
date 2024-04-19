package jp.co.yumemi.droidtraining.presentation.screen

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import jp.co.yumemi.droidtraining.presentation.components.RowButtons
import jp.co.yumemi.droidtraining.presentation.components.Temperature
import jp.co.yumemi.droidtraining.presentation.components.WeatherImage

@Composable
fun WeatherScreen(
    weather: String,
    onNextClick: () -> Unit,
    onReloadClick: () -> Unit,
) {
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
                WeatherImage(weather = weather)
                Temperature(modifier = Modifier.fillMaxWidth())
            }
            RowButtons(
                modifier = Modifier.constrainAs(buttons) {
                    val margin = 80.dp
                    top.linkTo(images.bottom, margin = margin)
                    start.linkTo(images.start)
                    end.linkTo(images.end)
                    width = Dimension.fillToConstraints
                },
                onNextClick = onNextClick,
                onReloadClick = onReloadClick
            )
        }
    }
}
