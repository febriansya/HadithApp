package com.example.tawakall.persentation.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tawakall.common.Resource
import com.example.tawakall.data.remote.dto.Hadith
import com.example.tawakall.domain.use_case.GetHadithUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getHadithUseCase: GetHadithUseCase
) : ViewModel() {
    private val _state = mutableStateOf(HadithListState())
    val state: State<HadithListState> = _state
    private var riwayah:String =""

    init {
        getHadith()
    }

    private fun getHadith() {
        getHadithUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val hadistList = result.data
                    _state.value =
                        HadithListState(hadith = result.data as List<Hadith>)
                }
                is Resource.Error -> {
                    _state.value =
                        HadithListState(error = result.message ?: "An unexpected error occured")
                }

                is Resource.Loading -> {
                    _state.value = HadithListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}