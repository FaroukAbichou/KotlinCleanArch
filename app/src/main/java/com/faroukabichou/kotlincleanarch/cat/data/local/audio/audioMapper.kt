package com.faroukabichou.kotlincleanarch.cat.data.local.audio

import com.faroukabichou.kotlincleanarch.cat.domain.Audio
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