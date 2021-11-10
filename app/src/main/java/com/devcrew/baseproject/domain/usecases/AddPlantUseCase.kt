package com.devcrew.baseproject.domain.usecases

import com.devcrew.baseproject.domain.entity.Plant
import com.devcrew.baseproject.domain.repo.PlantRepo
import javax.inject.Inject

class AddPlantUseCase @Inject constructor(
    private val plantRepo: PlantRepo
) {
    suspend fun addPlant(plant: Plant): Long = plantRepo.addPlant(plant)
}