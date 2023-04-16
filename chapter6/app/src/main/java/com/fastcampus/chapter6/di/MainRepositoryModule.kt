package com.fastcampus.chapter6.di

import com.fastcampus.chapter6.remote.MainService
import com.fastcampus.chapter6.remote.repository.MainRepository
import com.fastcampus.chapter6.remote.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MainRepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideMainRepository(
        mainService: MainService,
    ): MainRepository = MainRepositoryImpl(mainService)

}