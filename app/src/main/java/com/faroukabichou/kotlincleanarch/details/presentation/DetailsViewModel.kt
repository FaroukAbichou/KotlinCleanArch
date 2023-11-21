package com.faroukabichou.kotlincleanarch.details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faroukabichou.kotlincleanarch.cat.domain.CatRepository
import com.faroukabichou.kotlincleanarch.details.presentation.event.DetailsScreenEvent
import com.faroukabichou.kotlincleanarch.details.presentation.state.DetailsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DetailsViewModel : ViewModel(), KoinComponent {

    private val repository: CatRepository by inject()

    private val _state = MutableStateFlow(DetailsState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            DetailsState()
        )


    fun onEvent(event: DetailsScreenEvent) {
        when (event) {
            is DetailsScreenEvent.GetCatDetailsById -> getCatById(event.id)

            is DetailsScreenEvent.GetRandomCats -> getMultipleRandomCats(event.number)

            DetailsScreenEvent.GetRandomCat -> getMultipleRandomCats()
        }
    }

    private fun getCatById(id: String) {
        _state.value = _state.value.copy(
            isLoading = true,
        )

        viewModelScope.launch {
            repository
                .getCatById(id)
                .onSuccess {
                    _state.value = _state.value.copy(
                        isSuccess = true,
                        isLoading = false,
                        cat = it
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
