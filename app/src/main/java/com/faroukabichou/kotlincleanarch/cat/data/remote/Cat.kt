package com.faroukabichou.kotlincleanarch.cat.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    val data: List<CatItem>,
){
    @Serializable
    data class CatItem(
        val height: Int,
        val id: String,
        val url: String,
        val width: Int
    )
}