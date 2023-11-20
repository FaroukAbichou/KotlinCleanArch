package com.faroukabichou.kotlincleanarch.home.presentation.event


sealed interface HomeEvent {
    object Refresh : HomeEvent
}