package com.faroukabichou.kotlincleanarch.details.presentation.event

sealed interface DetailsScreenEvent {
    data class GetCatDetailsById(val id: String) : DetailsScreenEvent
    data class GetRandomCats(val number: Int) : DetailsScreenEvent
    object GetRandomCat : DetailsScreenEvent

}