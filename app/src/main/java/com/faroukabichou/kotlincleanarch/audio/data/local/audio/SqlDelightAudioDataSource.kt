package com.faroukabichou.kotlincleanarch.audio.data.local.audio

import com.faroukabichou.kotlincleanarch.audio.domain.Audio
import database.MyDatabase

class AudioDao(
    audioDatabase: MyDatabase
) {
    private val queries = audioDatabase.audioQueries
    fun insertAudio(audio: Audio) {
        queries.insertAudio(
            id = audio.id,
            title = audio.title,
            artist = audio.artist,
            artwork = audio.artwork,
            url = audio.url,
        )
    }

    fun getAllAudio(): List<AudioEntity> {
        return queries
            .getAllAudio()
            .executeAsList()
    }

    fun getAudioById(id : String): AudioEntity {
        return queries
            .getAudioById(id)
            .executeAsList()
            .last()
    }

    fun deleteAudio(id: String) {
        queries.deleteAudio(id)
    }

    fun updateAudio(audio: Audio) {
        queries.replaceAudio(
            id = audio.id,
            title = audio.title,
            artist = audio.artist,
            artwork = audio.artwork,
            url = audio.url,
        )
    }
}