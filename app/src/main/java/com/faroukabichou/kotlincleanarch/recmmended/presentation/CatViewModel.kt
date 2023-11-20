package com.faroukabichou.kotlincleanarch.recmmended.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faroukabichou.kotlincleanarch.cat.domain.CatRepository
import com.faroukabichou.kotlincleanarch.recmmended.presentation.event.CatScreenEvent
import com.faroukabichou.kotlincleanarch.recmmended.presentation.state.CatState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CatViewModel : ViewModel(), KoinComponent {

    private val repository: CatRepository by inject()

    private val _state = MutableStateFlow(CatState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            CatState()
        )


    fun onEvent(event: CatScreenEvent) {
        when (event) {
            CatScreenEvent.Refresh -> refresh()

            is CatScreenEvent.GetCatById -> getCatById(event.id)

        }
    }

    private fun refresh() {
        getMultipleRandomCats()
    }

    private fun getCatById(id: String) {

    }


    private fun getMultipleRandomCats(limit : Int = 10) {
        _state.value = _state.value.copy(
            isLoading = true,
        )

        viewModelScope.launch {
            repository
                .getMultipleRandomCats(limit)
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
