package com.faroukabichou.kotlincleanarch.recmmended.presentation.event

sealed interface CatScreenEvent {
    object Refresh : CatScreenEvent
    data class GetCatById(val id: String) : CatScreenEvent
}