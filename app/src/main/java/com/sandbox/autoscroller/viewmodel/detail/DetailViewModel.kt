package com.sandbox.autoscroller.viewmodel.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sandbox.autoscroller.model.models.CarDetails
import com.sandbox.autoscroller.model.models.Posts
import com.sandbox.autoscroller.model.repository.AutoRepository
import com.sandbox.autoscroller.view.LoadingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val repository: AutoRepository
) : ViewModel() {
    private val _loadingState: MutableStateFlow<LoadingState> =
        MutableStateFlow(LoadingState.Loading)
    val loadingState = _loadingState.asStateFlow()

    fun getInfo(carId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingState.value = LoadingState.Loading
            val details = async { repository.getCarDetails(carId) }
            val posts = async { repository.getCarPosts(carId) }
            val allInfo = awaitAll(details, posts)
                .runCatching { AllInfo(get(0) as CarDetails, get(1) as Posts) }
                .onSuccess { _loadingState.value = LoadingState.Success(it) }
                .onFailure { _loadingState.value = LoadingState.Error() }
        }
    }
}

data class AllInfo(
    val carDetails: CarDetails,
    val posts: Posts
)