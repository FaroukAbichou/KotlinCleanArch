package com.faroukabichou.kotlincleanarch.cat.data.remote

import com.faroukabichou.kotlincleanarch.cat.domain.Cat
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
    ){
        fun toCat() = Cat(
            id = id,
            width = width.toLong(),
            url = url,
            height = height.toLong()
        )
    }
}