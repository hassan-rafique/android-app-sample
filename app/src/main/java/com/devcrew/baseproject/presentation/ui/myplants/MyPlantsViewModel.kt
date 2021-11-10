package com.devcrew.baseproject.presentation.ui.myplants

import androidx.lifecycle.*
import com.devcrew.baseproject.domain.entity.Plant
import com.devcrew.baseproject.domain.usecases.AddPlantUseCase
import com.devcrew.baseproject.domain.usecases.DeletePlantUseCase
import com.devcrew.baseproject.domain.usecases.GetMyPlantsUseCase
import com.devcrew.baseproject.presentation.base.BaseViewModel
import com.devcrew.baseproject.presentation.utils.helper.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPlantsViewModel @Inject constructor(
    private val addPlantUseCase: AddPlantUseCase,
    private val getMyPlantsUseCase: GetMyPlantsUseCase,
    private val deletePlantUseCase: DeletePlantUseCase
) : BaseViewModel() {

    private val _responseMessage = SingleLiveEvent<String>()
    val responseMessage: SingleLiveEvent<String> = _responseMessage

    val myPlants = MutableLiveData<List<Plant>>()

    init {
        myPlants.value = emptyList()
    }

    fun addPlant(plant: Plant) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = addPlantUseCase.addPlant(plant)
                if (response.toInt() != 0)
                    _responseMessage.postValue("Plant Added Successfully")
                else
                    _responseMessage.postValue("Error")
            } catch (e: Exception) {
                e.printStackTrace()
                _responseMessage.postValue(e.message)
            }
        }
    }

    fun deletePlant(plant: Plant) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = deletePlantUseCase.deletePlant(plant)
                if (response.toString() != "0")
                    _responseMessage.postValue("Deleted")
                else
                    _responseMessage.postValue("Error")
            } catch (e: Exception) {
                e.printStackTrace()
                _responseMessage.postValue(e.message)
            }
        }
    }

    fun getPlantsList() = liveData {
        getMyPlantsUseCase.getMyPlants().collect {
            emit(it)
        }
    }

}