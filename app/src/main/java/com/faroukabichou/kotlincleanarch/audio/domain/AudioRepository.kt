package com.faroukabichou.kotlincleanarch.audio.domain

interface AudioRepository {
    suspend fun getAllAudios(): Result<List<Audio>>
    suspend fun getRecentlyPlayedAudios(): Result<List<Audio>>
    suspend fun insertAudioToRecentlyPlayed(audio: Audio) : Result<Unit>
    suspend fun replaceAudioOfRecentlyPlayed(audio: Audio) : Result<Unit>
}