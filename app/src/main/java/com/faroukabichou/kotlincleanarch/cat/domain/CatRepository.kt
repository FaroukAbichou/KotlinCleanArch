package com.faroukabichou.kotlincleanarch.cat.domain

import com.faroukabichou.kotlincleanarch.cat.data.remote.Cat

interface CatRepository {
    suspend fun getRandomCat(): Result<Cat.CatItem>
    suspend fun getMultipleRandomCats(limit: Int): Result<List<Cat.CatItem>>
    suspend fun getSpecificBreedCats(breedId: String, limit: Int, apiKey: String): Result<List<Cat.CatItem>>
    suspend fun getCatById(id: String): Result<Cat.CatItem>
}
