package jp.co.yumemi.droidtraining.presentation.state

sealed interface WeatherState {
    data object Loading : WeatherState
    data class Success(val weather: String) : WeatherState
    data class Error(val error: Throwable) : WeatherState
}
