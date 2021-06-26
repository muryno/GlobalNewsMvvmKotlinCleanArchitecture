package com.ubn.globalnewsmvvmarchitecture.presentation.di

import com.ubn.globalnewsmvvmarchitecture.data.api.NewsAPIService
import com.ubn.globalnewsmvvmarchitecture.data.repository.dataSource.NewsRemoteDataSource
import com.ubn.globalnewsmvvmarchitecture.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsAPIService: NewsAPIService
    ): NewsRemoteDataSource {
       return NewsRemoteDataSourceImpl(newsAPIService)
    }

}












