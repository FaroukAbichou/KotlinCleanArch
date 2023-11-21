package com.faroukabichou.kotlincleanarch.details.presentation.event

sealed interface DetailsScreenEvent {
    data class GetCatDetailsById(val id: String) : DetailsScreenEvent
    object GetRandomCat : DetailsScreenEvent

}