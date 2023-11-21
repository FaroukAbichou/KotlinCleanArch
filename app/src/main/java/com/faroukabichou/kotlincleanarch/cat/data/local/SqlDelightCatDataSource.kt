package com.faroukabichou.kotlincleanarch.cat.data.local

import com.faroukabichou.kotlincleanarch.MyDatabase
import com.faroukabichou.kotlincleanarch.cat.domain.Cat
import database.CatEntity

class CatDao(database: MyDatabase) {
    private val queries = database.catQueries

    fun insertCat(cat: Cat) {
        queries.insertCat(
            id = cat.id,
            url = cat.url,
            width = cat.width,
            height = cat.height
        )
    }

    fun getAllCats(): List<CatEntity> {
        return queries.getAllCats().executeAsList()
    }

    fun getCatById(id: String): CatEntity {
        return queries.getCatById(id).executeAsOne()
    }

    fun deleteCat(id: String) {
        queries.deleteCat(id)
    }

    fun updateCat(cat: Cat) {
        queries.replaceCat(
            id = cat.id,
            url = cat.url,
            width = cat.width,
            height = cat.height
        )
    }

    fun getRandomCat(): CatEntity {
        return queries.getRandomCat().executeAsOne()
    }

    fun getMultipleRandomCats(limit: Long): List<CatEntity> {
        return queries.getRandomCats(limit).executeAsList()
    }
}