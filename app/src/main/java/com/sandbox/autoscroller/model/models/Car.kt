package com.sandbox.autoscroller.model.models

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("brand_id")
    val brandId: Int,
    @SerializedName("brand_name")
    val brandName: String,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("country_name")
    val countryName: String,
    val engine: String,
    @SerializedName("engine_id")
    val engineId: Int,
    @SerializedName("engine_name")
    val engineName: String,
    @SerializedName("engine_volume")
    val engineVolume: String,
    @SerializedName("for_sale")
    val forSale: Int,
    val id: Int,
    val image: String,
    val images: List<Image>,
    @SerializedName("model_id")
    val modelId: Int,
    @SerializedName("model_name")
    val modelName: String,
    val name: String,
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("place_name")
    val placeName: String,
    val price: String,
    val thumbnail: String,
    @SerializedName("transmission_id")
    val transmissionId: Int,
    @SerializedName("transmission_name")
    val transmissionName: String,
    val year: Int
)