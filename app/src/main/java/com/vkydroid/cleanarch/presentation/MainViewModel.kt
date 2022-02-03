package com.vkydroid.cleanarch.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vkydroid.cleanarch.domain.People
import com.vkydroid.cleanarch.domain.common.Resource
import com.vkydroid.cleanarch.domain.usecases.GetPeopleListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val peopleListUseCase: GetPeopleListUseCase

) : ViewModel() {

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> get() = _dataLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _peopleList = MutableLiveData<List<People>>()
    val peopleList: LiveData<List<People>> get() = _peopleList

    fun getRemotePeopleList() {
        viewModelScope.launch(Dispatchers.IO) {
            _dataLoading.postValue(true)
            when (val response = peopleListUseCase()) {
                is Resource.Success -> {
                    _dataLoading.postValue(false)
                    _peopleList.postValue(response.data)
                }
                is Resource.Error -> {
                    _dataLoading.postValue(false)
                    _error.postValue(response.exception.message)
                }
            }
        }
    }

}