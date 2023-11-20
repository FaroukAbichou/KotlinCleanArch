package com.faroukabichou.kotlincleanarch.recmmended.presentation.state

import com.faroukabichou.kotlincleanarch.audio.domain.Audio

data class RecommendedState(
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val isFailure: Boolean = false,
    val audio: AudioList = AudioList(),
    val selectedAudio: SelectedAudio = SelectedAudio(),
    val playerInfo: PlayerInfo = PlayerInfo()
) {
    data class AudioList(
        val isSuccess: Boolean = false,
        val isLoading: Boolean = false,
        val isFailure: Boolean = false,
        val audioList: List<Audio> = emptyList()
    )

    data class SelectedAudio(
        val audio: Audio = Audio(
            id = "",
            title = "",
            artist = "",
            artwork = "",
            url = ""
        )
    )

    data class PlayerInfo(
        val currentPlayerPosition: Long = 0L,
        val currentSongDuration: Long = 0L,
        val isConnected: Boolean = false,
        val networkError: Boolean = false,
        val curPlayingSong: Audio? = null,
        val currentPlayingSong: Audio? = null,
        val currentPlaybackFormattedPosition: String = "",
        val currentSongFormattedPosition: String = "",
    )
}