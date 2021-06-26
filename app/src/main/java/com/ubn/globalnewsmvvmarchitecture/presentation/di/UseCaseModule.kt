package com.ubn.globalnewsmvvmarchitecture.presentation.di

import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepository
import com.ubn.globalnewsmvvmarchitecture.domain.usecase.GetNewsHeadlinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
   @Singleton
   @Provides
   fun provideGetNewsheadLinesUseCase(
       newsRepository: NewsRepository
   ): GetNewsHeadlinesUseCase {
      return GetNewsHeadlinesUseCase(newsRepository)
   }
}


















