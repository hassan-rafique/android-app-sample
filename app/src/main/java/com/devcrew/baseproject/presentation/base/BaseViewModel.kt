package com.devcrew.baseproject.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcrew.baseproject.presentation.utils.helper.RequestState

open class BaseViewModel : ViewModel() {

    protected val _state = MutableLiveData<RequestState>()
    val state: LiveData<RequestState>

    init {
        state = _state
    }
}