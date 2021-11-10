package com.devcrew.baseproject.data.remote

import com.devcrew.baseproject.domain.entity.Plant
import retrofit2.Response
import retrofit2.http.GET

interface PlantApi {

    @GET("plants.json")
    suspend fun getAllPlants(): Response<List<Plant>>
}