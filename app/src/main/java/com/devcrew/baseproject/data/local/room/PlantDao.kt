package com.devcrew.baseproject.data.local.room

import androidx.room.*
import com.devcrew.baseproject.domain.entity.Plant
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlant(plant: Plant): Long

    @Query("SELECT * FROM plant")
    fun getAllPlants(): Flow<List<Plant>>

    @Delete
    suspend fun deletePlant(plant: Plant): Int

    @Update
    suspend fun updatePlant(plant: Plant)
}