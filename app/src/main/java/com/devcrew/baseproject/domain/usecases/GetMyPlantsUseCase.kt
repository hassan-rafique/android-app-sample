package com.devcrew.baseproject.domain.usecases

import com.devcrew.baseproject.domain.repo.PlantRepo
import javax.inject.Inject

class GetMyPlantsUseCase @Inject constructor(
    private val plantRepo: PlantRepo
) {
    fun getMyPlants() = plantRepo.getMyPlants()
}