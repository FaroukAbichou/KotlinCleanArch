package com.faroukabichou.kotlincleanarch.cat.domain

interface CatRepository {
    suspend fun getRandomCat(useCache: Boolean): Result<Cat>
    suspend fun getCatById(useCache: Boolean, id: String): Result<Cat>
    suspend fun getMultipleRandomCats(useCache: Boolean, limit: Int): Result<List<Cat>>
    suspend fun getSpecificBreedCats(
        useCache: Boolean,
        breedId: String,
        limit: Int,
        apiKey: String
    ): Result<List<Cat>>
}
