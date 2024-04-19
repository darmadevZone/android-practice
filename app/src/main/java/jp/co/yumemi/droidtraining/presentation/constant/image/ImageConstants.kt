package jp.co.yumemi.droidtraining.presentation.constant.image

import jp.co.yumemi.droidtraining.R

enum class ImageConstants(val response: Int, val weather: String) {
    Sunny(R.drawable.sunny, "sunny"),
    Cloudy(R.drawable.cloudy, "cloudy"),
    Rainy(R.drawable.rainy, "rainy"),
    Snow(R.drawable.snow, "snow"), ;

    companion object {
        fun fromString(weather: String) = entries.find { it.weather == weather }
    }
}
