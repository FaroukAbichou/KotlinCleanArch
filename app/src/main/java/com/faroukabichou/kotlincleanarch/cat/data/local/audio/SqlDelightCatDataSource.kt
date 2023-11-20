package com.faroukabichou.kotlincleanarch.cat.data.local.audio

import com.faroukabichou.kotlincleanarch.MyDatabase
import com.faroukabichou.kotlincleanarch.cat.domain.Cat
import database.CatEntity

class CatDao(
    audioDatabase: MyDatabase
) {
    private val queries = audioDatabase.audioQueries
    fun insertAudio(audio: Cat) {
        queries.insertCat(
            height = audio.height,
            id = audio.id,
            url = audio.url,
            width = audio.width
        )
    }

    fun getAllAudio(): List<CatEntity> {
        return queries
            .getAllCats()
            .executeAsList()
    }

    fun getAudioById(id : String): CatEntity {
        return queries
            .getCatById(id)
            .executeAsList()
            .last()
    }

    fun deleteAudio(id: String) {
        queries.deleteCat(id)
    }

    fun updateAudio(audio: Cat) {
        queries.replaceCat(
            id = audio.id,
            height = audio.height,
            width = audio.width,
            url = audio.url,
        )
    }
}