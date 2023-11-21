package com.faroukabichou.kotlincleanarch.cat.data.repository

import com.faroukabichou.kotlincleanarch.cat.data.local.CatDao
import com.faroukabichou.kotlincleanarch.cat.data.remote.CatClient
import com.faroukabichou.kotlincleanarch.cat.domain.Cat
import com.faroukabichou.kotlincleanarch.cat.domain.CatRepository

class CatRepositoryImpl(
    private val catClient: CatClient,
    private val catDao: CatDao
) : CatRepository {

    override suspend fun getRandomCat(): Result<Cat> =
        safeApiCall { catClient.getRandomCat().toCat() }

    override suspend fun getMultipleRandomCats(
        limit: Int
    ): Result<List<Cat>> =
        safeApiCall { catClient.getMultipleRandomCats(limit).map { it.toCat() } }

    override suspend fun getSpecificBreedCats(
        breedId: String,
        limit: Int,
        apiKey: String
    ): Result<List<Cat>> =
        safeApiCall { catClient.getSpecificBreedCats(breedId, limit, apiKey).map { it.toCat() } }

    override suspend fun getCatById(id: String): Result<Cat> =
        safeApiCall { catClient.getCatById(id).toCat() }

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