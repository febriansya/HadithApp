package com.example.tawakall.persentation.screen.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tawakall.common.Resource
import com.example.tawakall.data.source.remote.dto.HadithData
import com.example.tawakall.domain.model.ReadHadith
import com.example.tawakall.domain.use_case.FetchHadistUseCaseApi
import com.example.tawakall.domain.use_case.RoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class GetHadistViewModel @Inject constructor(
    private val useCaseNew: RoomUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(HadithListState())
    val state: State<HadithListState> = _state



    fun getAllNewHadist(tabindex: Int) {
        when (tabindex) {
            0 -> useCaseNew.fetchHadistUseCaseApi.invoke("abu-daud", "1-300").onEach { result ->
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
                            HadithListState(
                                error = result.message ?: "An Unexpected error occured "
                            )
                    }
                }
            }
            1 -> useCaseNew.fetchHadistUseCaseApi.invoke("bukhari", "1-200").onEach { result ->
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
                            HadithListState(
                                error = result.message ?: "An Unexpected error occured "
                            )
                    }
                }
            }
            2 -> useCaseNew.fetchHadistUseCaseApi.invoke("tirmidzi", "1-200").onEach { result ->
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
                            HadithListState(
                                error = result.message ?: "An Unexpected error occured "
                            )
                    }
                }
            }
            3 -> useCaseNew.fetchHadistUseCaseApi.invoke("nasai", "1-200").onEach { result ->
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
                            HadithListState(
                                error = result.message ?: "An Unexpected error occured "
                            )
                    }
                }
            }
            4 -> useCaseNew.fetchHadistUseCaseApi.invoke("ibnu-majah", "1-200").onEach { result ->
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
                            HadithListState(
                                error = result.message ?: "An Unexpected error occured "
                            )
                    }
                }
            }
            5 -> useCaseNew.fetchHadistUseCaseApi.invoke("ahmad", "1-200").onEach { result ->
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
                            HadithListState(
                                error = result.message ?: "An Unexpected error occured "
                            )
                    }
                }
            }
            6 -> useCaseNew.fetchHadistUseCaseApi.invoke("darimi", "1-200").onEach { result ->
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
                            HadithListState(
                                error = result.message ?: "An Unexpected error occured "
                            )
                    }
                }
            }
            7 -> useCaseNew.fetchHadistUseCaseApi.invoke("malik", "1-200").onEach { result ->
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
                            HadithListState(
                                error = result.message ?: "An Unexpected error occured "
                            )
                    }
                }
            }
            8 -> useCaseNew.fetchHadistUseCaseApi.invoke("muslim", "1-200").onEach { result ->
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
                            HadithListState(
                                error = result.message ?: "An Unexpected error occured "
                            )
                    }
                }
            }
            else -> useCaseNew.fetchHadistUseCaseApi.invoke("muslim", "1-20").onEach { result ->
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
                            HadithListState(
                                error = result.message ?: "An Unexpected error occured "
                            )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }






}

