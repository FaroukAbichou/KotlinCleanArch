package com.faroukabichou.kotlincleanarch.audio.domain

data class Audio(
    val id: String,
    val title: String,
    val artist: String,
    val artwork: String,
    val url: String
) {
    companion object {
        val demoItem get() = Audio(
            id = "1",
            title = "Demo Song",
            artist = "Demo Artist",
            artwork = "https://picsum.photos/200",
            url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
        )
    }
}