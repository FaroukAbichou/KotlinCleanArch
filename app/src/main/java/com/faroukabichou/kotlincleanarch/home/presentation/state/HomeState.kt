package com.faroukabichou.kotlincleanarch.home.presentation.state

data class HomeState(
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val isFailure: Boolean = false,

) {
    data class AudioList(
        val isLoading: Boolean = false,
        val isFailure: Boolean = false,
        val isSuccess: Boolean = false,
    )

    data class User(
        val profilePicture: String = "https://images.unsplash.com/photo-1682847842481-f3e527151055?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=687&q=80",
    )
}