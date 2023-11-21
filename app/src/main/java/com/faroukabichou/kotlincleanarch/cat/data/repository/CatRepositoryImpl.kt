package com.faroukabichou.kotlincleanarch.cat.data.repository

import com.faroukabichou.kotlincleanarch.cat.data.local.CatDao
import com.faroukabichou.kotlincleanarch.cat.data.local.toCat
import com.faroukabichou.kotlincleanarch.cat.data.remote.CatClient
import com.faroukabichou.kotlincleanarch.cat.domain.Cat
import com.faroukabichou.kotlincleanarch.cat.domain.CatRepository

class CatRepositoryImpl(
    private val catClient: CatClient,
    private val catDao: CatDao
) : CatRepository {

    override suspend fun getRandomCat(useCache: Boolean): Result<Cat> {
        return if (useCache) {
            runCatching { catDao.getRandomCat().toCat() }
        } else {
            runCatching { catClient.getRandomCat().toCat() }
        }
    }

    override suspend fun getMultipleRandomCats(
        useCache: Boolean,
        limit: Int
    ): Result<List<Cat>> {
        return if (useCache) {
            runCatching { catDao.getMultipleRandomCats(limit.toLong()).map { it.toCat() } }
        } else {
            runCatching {
                catClient.getMultipleRandomCats(limit).map { it.toCat() }
            }
        }

    }

    override suspend fun getSpecificBreedCats(
        useCache: Boolean,
        breedId: String,
        limit: Int,
        apiKey: String
    ): Result<List<Cat>> {
        return if (useCache) {
            runCatching {
                catDao.getMultipleRandomCats(limit.toLong()).map { it.toCat() }
            }
        } else {
            runCatching { catClient.getSpecificBreedCats(breedId, limit, apiKey).map { it.toCat() } }
        }
    }

    override suspend fun getCatById(useCache: Boolean, id: String): Result<Cat> {
        return if (useCache) {
            runCatching { catDao.getCatById(id).toCat() }
        } else {
            runCatching { catClient.getCatById(id).toCat() }
        }
    }

}