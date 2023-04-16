package com.fastcampus.chapter8.di

import com.fastcampus.chapter8.data.repository.ContentRepositoryImpl
import com.fastcampus.chapter8.data.source.local.dao.ContentDao
import com.fastcampus.chapter8.data.source.remote.api.ContentService
import com.fastcampus.chapter8.domain.repository.ContentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesContentRepository(
        contentService: ContentService,
        contentDao: ContentDao
    ): ContentRepository = ContentRepositoryImpl(contentService, contentDao)
}