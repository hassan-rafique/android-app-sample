package com.devcrew.baseproject.domain.usecases

import com.devcrew.baseproject.domain.repo.PlantRepo
import javax.inject.Inject

class GetAllPlantsUseCase @Inject constructor(
    private val plantRepo: PlantRepo
) {
    suspend fun getAllPlants() = plantRepo.getAllPlants()
}