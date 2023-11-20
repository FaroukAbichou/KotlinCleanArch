package com.faroukabichou.kotlincleanarch.audio.data.remote

import com.faroukabichou.kotlincleanarch.core.network.helper.handleErrors
import io.ktor.client.*
import io.ktor.client.request.*


class AudioClient(
    private val httpClient: HttpClient
) {
    private val route = "b5f54ecf-c5ea-4e62-90d2-83e76606a922"

    suspend fun getAllAudios(): List<AudioData> = handleErrors<AudioResponse> {
        httpClient.get(route)
    }.data

}
