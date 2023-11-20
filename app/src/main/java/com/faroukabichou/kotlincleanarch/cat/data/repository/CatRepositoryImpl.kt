package com.faroukabichou.kotlincleanarch.cat.data.repository

import com.faroukabichou.kotlincleanarch.cat.data.local.audio.CatDao
import com.faroukabichou.kotlincleanarch.cat.data.remote.Cat
import com.faroukabichou.kotlincleanarch.cat.data.remote.CatClient
import com.faroukabichou.kotlincleanarch.cat.domain.CatRepository

class CatRepositoryImpl(
    private val catClient: CatClient,
    private val catDao: CatDao
) : CatRepository {

    override suspend fun getRandomCat(): Result<Cat.CatItem> =
        safeApiCall { catClient.getRandomCat() }

    override suspend fun getMultipleRandomCats(
        limit: Int
    ): Result<List<Cat.CatItem>> =
        safeApiCall { catClient.getMultipleRandomCats(limit) }

    override suspend fun getSpecificBreedCats(
        breedId: String,
        limit: Int,
        apiKey: String
    ): Result<List<Cat.CatItem>> =
        safeApiCall { catClient.getSpecificBreedCats(breedId, limit, apiKey) }

    override suspend fun getCatById(id: String): Result<Cat.CatItem> =
        safeApiCall { catClient.getCatById(id) }

    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
        return try {
            val data = apiCall()
            Result.success(data)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}