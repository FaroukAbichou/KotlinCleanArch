package com.faroukabichou.kotlincleanarch.details.presentation.event

sealed interface DetailsScreenEvent {
    data class GetDetailsById(val id: String) : DetailsScreenEvent
}