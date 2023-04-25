package ir.kaaveh.balloontest

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _tooltipState = mutableStateOf(0)
    val tooltipState: State<Int> = _tooltipState

    val tooltipSize = 2

    init {
        viewModelScope.launch {
            delay(2000L)
            _tooltipState.value = 1
        }
    }

    fun onTooltipNext() {
        if (_tooltipState.value < tooltipSize) {
            _tooltipState.value++
        }
    }

    fun onTooltipPrevious() {
        if (1 < _tooltipState.value) {
            _tooltipState.value--
        }
    }

    fun onTooltipDismissed() {
        _tooltipState.value = 0
    }

}