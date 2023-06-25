package com.sandbox.autoscroller.view

sealed class LoadingState(data: Any) {
    object Loading : LoadingState(data = Any())
    class Success(val data: Any) : LoadingState(data)
    class Error(val message: String = "Something went wrong...") : LoadingState(data = Any())
}