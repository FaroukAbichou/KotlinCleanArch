package com.faroukabichou.kotlincleanarch.cat.data.remote

import com.faroukabichou.kotlincleanarch.core.network.NetworkConstants.BASE_URL
import com.faroukabichou.kotlincleanarch.core.network.helper.handleErrors
import io.ktor.client.*
import io.ktor.client.request.*

class CatClient(
    private val httpClient: HttpClient
) {
    private val route = BASE_URL

    suspend fun getRandomCat(): Cat.CatItem = handleErrors<Cat> {
        httpClient.get("$route/images/search")
    }.data.first()

    suspend fun getMultipleRandomCats(limit: Int = 10): List<Cat.CatItem> = handleErrors<List<Cat.CatItem>> {
        httpClient.get("$route/images/search?limit=$limit")
    }

    suspend fun getSpecificBreedCats(breedId: String, limit: Int = 10, apiKey: String): List<Cat.CatItem> = handleErrors<List<Cat.CatItem>> {
        httpClient.get("$route/images/search?limit=$limit&breed_ids=$breedId&api_key=$apiKey")
    }

    suspend fun getCatById(id: String): Cat.CatItem = handleErrors<Cat.CatItem> {
        httpClient.get("$route/images/$id")
    }
}
