package com.devcrew.baseproject.domain.usecases

import com.devcrew.baseproject.domain.entity.Plant
import com.devcrew.baseproject.domain.repo.PlantRepo
import javax.inject.Inject

class DeletePlantUseCase @Inject constructor(
    private val plantRepo: PlantRepo
) {
    suspend fun deletePlant(plant: Plant) = plantRepo.deletePlant(plant)
}