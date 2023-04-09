package com.example.tawakall.persentation.screen.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tawakall.domain.model.ReadHadith
import com.example.tawakall.domain.use_case.insert.InsertHadithUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailVIewModel @Inject constructor(
    private val insertHadithUseCase: InsertHadithUseCase
) : ViewModel() {

//    berhasil add data ui state

    private var _state = mutableStateOf(DetailState())
    val stateRead:State<DetailState> = _state
    val scope = viewModelScope

    fun insertRead(readHadith: ReadHadith){
        scope.launch {
            insertHadithUseCase.invoke(readHadith)
        }
    }

}