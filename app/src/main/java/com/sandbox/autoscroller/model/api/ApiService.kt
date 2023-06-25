package com.sandbox.autoscroller.model.api

import com.sandbox.autoscroller.model.models.Car
import com.sandbox.autoscroller.model.models.CarDetails
import com.sandbox.autoscroller.model.models.Posts
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("cars/list")
    suspend fun getCars(): List<Car>

    @GET("cars/list/")
    suspend fun getCars(@Query("items") pageSize: Int, @Query("page") page: Int): List<Car>

    @GET("car/{id}")
    suspend fun getCarDetails(@Path("id") id: Int): CarDetails

    @GET("car/{id}/posts")
    suspend fun getCarPosts(@Path("id") id: Int): Posts
}