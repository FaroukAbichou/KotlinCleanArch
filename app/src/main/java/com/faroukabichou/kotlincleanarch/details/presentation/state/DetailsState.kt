package com.faroukabichou.kotlincleanarch.details.presentation.state

import com.faroukabichou.kotlincleanarch.cat.domain.Cat

data class DetailsState(
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val isFailure: Boolean = false,
    val cat: List<Cat> = emptyList()
)