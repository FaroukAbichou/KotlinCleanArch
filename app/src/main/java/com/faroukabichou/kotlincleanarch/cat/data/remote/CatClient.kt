package com.faroukabichou.kotlincleanarch.cat.data.remote

import com.faroukabichou.kotlincleanarch.core.network.NetworkConstants.BASE_URL
import com.faroukabichou.kotlincleanarch.core.network.helper.handleErrors
import io.ktor.client.*
import io.ktor.client.request.*

class CatClient(
    private val httpClient: HttpClient
) {
    private val route = BASE_URL

    suspend fun getRandomCats(limit: Int = 10): List<CatResponse> = handleErrors<List<CatResponse>> {
        httpClient.get("$route/images/search?limit=$limit")
    }

    suspend fun getSpecificBreedCats(breedId: String, limit: Int = 10, apiKey: String): List<CatResponse> = handleErrors<List<CatResponse>> {
        httpClient.get("$route/images/search?limit=$limit&breed_ids=$breedId&api_key=$apiKey")
    }

    suspend fun getCatById(id: String): CatResponse = handleErrors<CatResponse> {
        httpClient.get("$route/images/$id")
    }
}
