package com.faroukabichou.kotlincleanarch.recmmended.presentation.event

sealed interface RecommendedEvent {
    object Refresh : RecommendedEvent
    data class GetAudioById(val id: String) : RecommendedEvent
}