package com.example.lessonhilt.presentation


import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lessonhilt.domain.GetUsefulActivityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getUsefulActivityUseCase: GetUsefulActivityUseCase) :
    ViewModel() {

    private var _state = MutableStateFlow<State>(State.Loading)
    var state = _state.asStateFlow()


    fun reloadUsefulActivity() {
        viewModelScope.launch {
            _state.value = State.Loading

            try {
                val reloadUsefulActivity = getUsefulActivityUseCase.execute().activity
                _state.value = State.Success(reloadUsefulActivity)
            } catch (e: Throwable) {
                Toast.makeText(MainActivity(), e.message.toString(), Toast.LENGTH_LONG)
            }


        }
    }

}