package com.example.lessonhilt.presentation

sealed class State {
    object Loading : State()
    data class Success(val activity: String) : State()
}
