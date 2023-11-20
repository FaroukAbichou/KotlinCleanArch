package com.faroukabichou.kotlincleanarch.audio.data.local.audio

import com.faroukabichou.kotlincleanarch.audio.domain.Audio
import database.AudioEntity

fun AudioEntity.toAudio(): Audio {
    return Audio(
        id = id,
        title = title,
        artist = artist,
        artwork = artwork,
        url = url,
    )
}