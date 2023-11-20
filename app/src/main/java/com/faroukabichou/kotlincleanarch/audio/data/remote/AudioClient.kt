package com.faroukabichou.kotlincleanarch.audio.data.remote

import com.faroukabichou.kotlincleanarch.core.network.NetworkConstants.BASE_URL
import com.faroukabichou.kotlincleanarch.core.network.helper.handleErrors
import io.ktor.client.*
import io.ktor.client.request.*


class AudioClient(
    private val httpClient: HttpClient
) {
    private val route = BASE_URL

    suspend fun getAllAudios(): List<AudioData> = handleErrors<AudioResponse> {
        httpClient.get(route)
    }.data

}
