package com.example.tawakall.persentation.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tawakall.domain.model.ReadHadith
import com.example.tawakall.domain.use_case.RoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ReadLastViewModel @Inject constructor(
    val useCase: RoomUseCase
) : ViewModel() {

    private val _lastRead = mutableListOf<List<ReadHadith>>()
    val stateRead = _lastRead

    init {
        getLastRead()
    }

    fun getLastRead() {
        useCase.getLastHadithUseCase.invoke().onEach {
            _lastRead.add(it)
        }
            .launchIn(viewModelScope)
    }

}