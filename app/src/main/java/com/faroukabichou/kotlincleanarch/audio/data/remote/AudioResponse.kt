package com.faroukabichou.kotlincleanarch.audio.data.remote

import com.faroukabichou.kotlincleanarch.audio.domain.Audio
import kotlinx.serialization.Serializable

@Serializable
data class AudioResponse(
    val data: List<AudioData>
)

@Serializable
data class AudioData(
    val id: String,
    val title: String,
    val artist: String,
    val artwork: String,
    val url: String
){

    fun toSong() = Audio(
        id = id,
        title = title,
        artist = artist,
        url = url,
        artwork = artwork
    )
}