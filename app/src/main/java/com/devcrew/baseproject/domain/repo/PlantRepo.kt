package com.devcrew.baseproject.domain.repo

import com.devcrew.baseproject.domain.entity.Plant
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface PlantRepo {

    suspend fun getAllPlants(): Response<List<Plant>>

    suspend fun addPlant(plant: Plant): Long

    fun getMyPlants(): Flow<List<Plant>>

    suspend fun deletePlant(plant: Plant): Int
}