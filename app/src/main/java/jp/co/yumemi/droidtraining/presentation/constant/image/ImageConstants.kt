package jp.co.yumemi.droidtraining.presentation.constant.image

import jp.co.yumemi.droidtraining.R

enum class ImageConstants(val response: Int, val weather: String) {
    Sunny(R.drawable.sunny, "sunny"),
    Cloudy(R.drawable.cloudy, "cloudy"),
    Rainy(R.drawable.rainy, "rainy"),
    Snow(R.drawable.snow, "snow"), ;

class ImageConstants {
    companion object {
        val sunny: Int = R.drawable.sunny
        val cloudy: Int = R.drawable.cloudy
        val rainy: Int = R.drawable.rainy
        val snow: Int = R.drawable.snow
    }
}

