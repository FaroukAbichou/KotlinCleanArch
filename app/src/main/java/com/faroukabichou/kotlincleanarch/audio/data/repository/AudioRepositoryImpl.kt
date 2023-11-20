package com.faroukabichou.kotlincleanarch.audio.data.repository

import com.faroukabichou.kotlincleanarch.audio.data.local.audio.AudioDao
import com.faroukabichou.kotlincleanarch.audio.data.local.audio.toAudio
import com.faroukabichou.kotlincleanarch.audio.data.remote.AudioClient
import com.faroukabichou.kotlincleanarch.audio.domain.Audio
import com.faroukabichou.kotlincleanarch.audio.domain.AudioRepository

class AudioRepositoryImpl(
    private val audioClient: AudioClient,
    private val audioDao: AudioDao
) : AudioRepository {

    override suspend fun getAllAudios(): Result<List<Audio>> {
        return try {
            val data = audioClient.getAllAudios().map { it.toSong() }
            Result.success(data)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getRecentlyPlayedAudios(): Result<List<Audio>> {
        return try {
            val data = audioDao.getAllAudio().map { it.toAudio() }
            Result.success(data)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun insertAudioToRecentlyPlayed(audio: Audio): Result<Unit> {
        return try {
            audioDao.insertAudio(audio)
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun replaceAudioOfRecentlyPlayed(audio: Audio): Result<Unit> {
        return try {
            audioDao.updateAudio(audio)
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}