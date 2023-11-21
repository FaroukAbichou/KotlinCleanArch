package com.faroukabichou.kotlincleanarch.cat.data.local

import com.faroukabichou.kotlincleanarch.cat.domain.Cat
import database.CatEntity

fun CatEntity.toCat(): Cat {
    return Cat(
        height = height,
        id = id,
        url = url,
        width = width
    )
}