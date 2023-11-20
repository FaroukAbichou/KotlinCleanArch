package com.faroukabichou.kotlincleanarch.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faroukabichou.kotlincleanarch.cat.domain.Audio
import com.faroukabichou.kotlincleanarch.cat.domain.CatRepository
import com.faroukabichou.kotlincleanarch.home.presentation.event.HomeEvent
import com.faroukabichou.kotlincleanarch.home.presentation.state.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class HomeViewModel : ViewModel(), KoinComponent {

    private val repository: CatRepository by inject()

    private val _state = MutableStateFlow(HomeState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            HomeState()
        )

    init {
        getAllAudio()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.Refresh -> {
                getAllAudio()
            }
        }
    }

    private fun getAllAudio() {
        _state.value = _state.value.copy(
            isLoading = true,
        )

        viewModelScope.launch {
            repository
                .getAllAudios()
                .onSuccess {
                    _state.value = _state.value.copy(
                        // TODO:
                        isSuccess = true,
                        isLoading = false,
                    )
                }
                .onFailure {
                    _state.value = _state.value.copy(
                        isFailure = true,
                        isLoading = false,
                    )
                }

        }
    }

    private fun getRecentlyPlayedAudios() {
        viewModelScope.launch {
            repository
                .getRecentlyPlayedAudios()
                .onSuccess {
                    _state.value = _state.value.copy(
                        // TODO:
                    )
                }
                .onFailure {
                    _state.value = _state.value.copy(
                        // TODO:
                    )
                }
        }
    }

    private fun insertAudioToRecentlyPlayed(
        audio: Audio
    ) {
        viewModelScope.launch {
            repository
                .insertAudioToRecentlyPlayed(audio)
                .onSuccess {
                    _state.value = _state.value.copy(
                        // TODO:
                    )
                }
                .onFailure {
                    _state.value = _state.value.copy(
                        // TODO:
                    )
                }
        }
    }
}