package com.sandbox.autoscroller.viewmodel.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sandbox.autoscroller.model.repository.AutoRepository
import com.sandbox.autoscroller.view.LoadingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class FeedViewModel @Inject constructor(
    private val repository: AutoRepository
) : ViewModel() {
    private val _loadingState: MutableStateFlow<LoadingState> =
        MutableStateFlow(LoadingState.Loading)
    val loadingState = _loadingState.asStateFlow()

    private var currentPage = 1
    private var pageSize = 9

    fun getCars() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val cars = repository.getCars(pageSize, currentPage)
                _loadingState.value = LoadingState.Success(cars)
                currentPage++
            } catch (e: Exception) {
                _loadingState.value = LoadingState.Error()
            }
        }
    }
}