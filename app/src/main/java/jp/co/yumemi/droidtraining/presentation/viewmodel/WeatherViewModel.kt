package jp.co.yumemi.droidtraining.presentation.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import jp.co.yumemi.api.YumemiWeather
import jp.co.yumemi.droidtraining.presentation.state.WeatherState

class WeatherViewModel : ViewModel() {
    private val _weatherState = mutableStateOf<WeatherState>(WeatherState.Loading)
    val weatherState = _weatherState

    fun getWeather(context: Context) {
        try {
            val response = YumemiWeather(context).fetchThrowsWeather()
            _weatherState.value = WeatherState.Success(weather = response)
        } catch (e: Throwable) {
            _weatherState.value = WeatherState.Error(error = e)
        }
    }
}
