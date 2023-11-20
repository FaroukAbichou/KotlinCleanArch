package com.faroukabichou.kotlincleanarch.cat.domain

data class Cat(
    val height: Long?,
    val id: String,
    val url: String?,
    val width: Long?
) {
    companion object {
        val demoItem
            get() = Cat(
                height = 10,
                id = "RandomId",
                url = "https://i.imgflip.com/83p2ha.jpg",
                width = 10
            )
    }
}