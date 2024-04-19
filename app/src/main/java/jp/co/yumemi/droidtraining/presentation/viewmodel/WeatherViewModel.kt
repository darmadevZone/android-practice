package jp.co.yumemi.droidtraining.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import jp.co.yumemi.api.YumemiWeather
import jp.co.yumemi.droidtraining.presentation.state.WeatherState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WeatherViewModel : ViewModel() {
    private val _weatherState = MutableStateFlow<WeatherState>(WeatherState.Loading)
    val weatherState: StateFlow<WeatherState> = _weatherState.asStateFlow()

    fun getWeather(context: Context) {
        try {
            val response = YumemiWeather(context).fetchThrowsWeather()
            _weatherState.value = WeatherState.Success(weather = response)
        } catch (e: Throwable) {
            _weatherState.value = WeatherState.Error(error = e)
        }
    }
}
