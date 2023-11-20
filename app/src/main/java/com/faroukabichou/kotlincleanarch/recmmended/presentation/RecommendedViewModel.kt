package com.faroukabichou.kotlincleanarch.recmmended.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faroukabichou.kotlincleanarch.cat.domain.Audio
import com.faroukabichou.kotlincleanarch.cat.domain.CatRepository
import com.faroukabichou.kotlincleanarch.recmmended.presentation.event.RecommendedEvent
import com.faroukabichou.kotlincleanarch.recmmended.presentation.state.RecommendedState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RecommendedViewModel : ViewModel(), KoinComponent {

    private val repository: CatRepository by inject()

    private val _state = MutableStateFlow(RecommendedState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            RecommendedState()
        )

    init {
        getAllAudio()
    }

    fun onEvent(event: RecommendedEvent) {
        when (event) {
            RecommendedEvent.Refresh -> {
                getAllAudio()
            }

            is RecommendedEvent.GetAudioById -> {
                _state.value = _state.value.copy(
                    selectedAudio = RecommendedState.SelectedAudio(
                        audio = getAudioById(event.id)
                    )
                )
            }
        }
    }

    private fun getAudioById(id: String): Audio {
        return _state.value.audio.audioList.find {
            it.id == id
        } ?: Audio.demoItem
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
                        isSuccess = true,
                        isLoading = false,
                        audio = RecommendedState.AudioList(
                            isSuccess = true,
                            isLoading = false,
                            audioList = it
                        )
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
}
