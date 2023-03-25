package com.example.tawakall.persentation.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tawakall.common.Resource
import com.example.tawakall.domain.use_case.HadistUseCaseNew
import com.example.tawakall.persentation.screen.data.remote.dto.HadithData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class GetHadistViewModel @Inject constructor(
    private val useCaseNew: HadistUseCaseNew
) : ViewModel() {

    private val _state = mutableStateOf(HadithListState())
    val state: State<HadithListState> = _state

    init {
        getAllNewHadist("bukhari", "1-10")
    }

    fun getAllNewHadist(id: String, range: String) {
        useCaseNew.invoke(id, range).onEach { result ->
            val hadistList = result.data
            when (result) {
                is Resource.Success -> {
                    _state.value = HadithListState(
                        riwayah = hadistList as HadithData
                    )
                }
                is Resource.Loading -> {
                    _state.value = HadithListState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value =
                        HadithListState(error = result.message ?: "An Unexpected error occured ")
                }
            }
        }.launchIn(viewModelScope)
    }
}

