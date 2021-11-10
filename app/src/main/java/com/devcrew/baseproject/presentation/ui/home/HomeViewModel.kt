package com.devcrew.baseproject.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.devcrew.baseproject.domain.entity.Plant
import com.devcrew.baseproject.domain.usecases.GetAllPlantsUseCase
import com.devcrew.baseproject.presentation.base.BaseViewModel
import com.devcrew.baseproject.presentation.utils.helper.RequestState
import com.devcrew.baseproject.presentation.utils.helper.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPlantsUseCase: GetAllPlantsUseCase
) : BaseViewModel() {

    private val _plantsList = MutableLiveData<List<Plant>>()
    val plantsList: LiveData<List<Plant>>

    private val _responseMessage = SingleLiveEvent<String>()
    val responseMessage: SingleLiveEvent<String>

    init {
        _plantsList.value = emptyList()
        plantsList = _plantsList
        responseMessage = _responseMessage
        getAllPlants()
    }

    private fun getAllPlants() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.postValue(RequestState.LOADING)
            try {
                val response = getAllPlantsUseCase.getAllPlants()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _plantsList.postValue(it)
                        _responseMessage.postValue("Success")
                    }
                } else {
                    _responseMessage.postValue(response.errorBody()?.string() ?: "")
                }
                _state.postValue(RequestState.DONE)
            } catch (e: Exception) {
                e.printStackTrace()
                _responseMessage.postValue(e.message)
                _state.postValue(RequestState.ERROR)
            } catch (t: Throwable) {
                t.printStackTrace()
                _responseMessage.postValue(t.message)
                _state.postValue(RequestState.ERROR)
            }
        }
    }
}