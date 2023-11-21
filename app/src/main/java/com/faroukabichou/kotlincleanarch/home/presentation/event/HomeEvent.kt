package com.faroukabichou.kotlincleanarch.home.presentation.event


sealed interface HomeEvent {
    object GetRandomCats : HomeEvent


}