package com.sandbox.autoscroller.model.repository

import com.sandbox.autoscroller.model.api.ApiService
import com.sandbox.autoscroller.model.models.Car
import com.sandbox.autoscroller.model.models.CarDetails
import com.sandbox.autoscroller.model.models.Posts
import javax.inject.Inject


class AutoRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun getCars(): List<Car> = api.getCars()

    suspend fun getCars(pageSize: Int, page: Int): List<Car> = api.getCars(pageSize, page)

    suspend fun getCarDetails(id: Int): CarDetails = api.getCarDetails(id)

    suspend fun getCarPosts(id: Int): Posts = api.getCarPosts(id)
}