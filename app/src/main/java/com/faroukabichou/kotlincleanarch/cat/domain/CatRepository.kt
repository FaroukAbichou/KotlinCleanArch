package com.faroukabichou.kotlincleanarch.cat.domain

interface CatRepository {
    suspend fun getRandomCat(): Result<Cat>
    suspend fun getMultipleRandomCats(limit: Int): Result<List<Cat>>
    suspend fun getSpecificBreedCats(breedId: String, limit: Int, apiKey: String): Result<List<Cat>>
    suspend fun getCatById(id: String): Result<Cat>
}
