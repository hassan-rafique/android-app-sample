package com.devcrew.baseproject.presentation.core.di

import android.content.Context
import com.devcrew.baseproject.data.local.room.AppDatabase
import com.devcrew.baseproject.data.local.room.PlantDao
import com.devcrew.baseproject.data.remote.PlantApi
import com.devcrew.baseproject.data.repo.PlantRepoImpl
import com.devcrew.baseproject.data.utils.BASE_URL
import com.devcrew.baseproject.domain.repo.PlantRepo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PlantModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun providePlantApi(gson: Gson): PlantApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(PlantApi::class.java)

    @Provides
    @Singleton
    fun providePlantRepo(plantApi: PlantApi, plantDao: PlantDao): PlantRepo {
        return PlantRepoImpl(plantApi, plantDao)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = AppDatabase.getDataBase(context)

    @Singleton
    @Provides
    fun providePlantDao(db: AppDatabase) = db.plantDao()
}