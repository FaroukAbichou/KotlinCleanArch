package com.faroukabichou.kotlincleanarch.home.presentation.state

import com.faroukabichou.kotlincleanarch.cat.domain.Cat

data class HomeState(
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val isFailure: Boolean = false,
    val cats: List<Cat>? = null,
)