package com.ubn.globalnewsmvvmarchitecture.presentation.di

import com.ubn.globalnewsmvvmarchitecture.data.repository.NewsRepositoryImpl
import com.ubn.globalnewsmvvmarchitecture.data.repository.dataSource.NewsLocalDataSource
import com.ubn.globalnewsmvvmarchitecture.data.repository.dataSource.NewsRemoteDataSource
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource,newsLocalDataSource)
    }

}














