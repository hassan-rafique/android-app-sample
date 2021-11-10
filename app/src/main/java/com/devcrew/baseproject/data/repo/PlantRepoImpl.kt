package com.devcrew.baseproject.data.repo

import com.devcrew.baseproject.data.local.room.PlantDao
import com.devcrew.baseproject.data.remote.PlantApi
import com.devcrew.baseproject.domain.entity.Plant
import com.devcrew.baseproject.domain.repo.PlantRepo
import javax.inject.Inject

class PlantRepoImpl @Inject constructor(
    private val plantApi: PlantApi,
    private val plantDao: PlantDao
) : PlantRepo {
    override suspend fun getAllPlants() = plantApi.getAllPlants()

    override suspend fun addPlant(plant: Plant): Long = plantDao.addPlant(plant)

    override fun getMyPlants() = plantDao.getAllPlants()

    override suspend fun deletePlant(plant: Plant): Int = plantDao.deletePlant(plant)
}