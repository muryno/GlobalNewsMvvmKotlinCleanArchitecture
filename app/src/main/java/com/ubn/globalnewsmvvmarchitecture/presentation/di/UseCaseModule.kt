package com.ubn.globalnewsmvvmarchitecture.presentation.di

import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepository
import com.ubn.globalnewsmvvmarchitecture.domain.usecase.GetNewsHeadlinesUseCase
import com.ubn.globalnewsmvvmarchitecture.domain.usecase.GetSavedNewsUseCase
import com.ubn.globalnewsmvvmarchitecture.domain.usecase.GetSearchedNewsUseCase
import com.ubn.globalnewsmvvmarchitecture.domain.usecase.SaveNewsUseCase
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


   @Singleton
   @Provides
   fun provideGetSearchedNewsheadLinesUseCase(
      newsRepository: NewsRepository
   ): GetSearchedNewsUseCase {
      return GetSearchedNewsUseCase(newsRepository)
   }

   @Singleton
   @Provides
   fun provideSavesUseCase(
      newsRepository: NewsRepository
   ): SaveNewsUseCase {
      return SaveNewsUseCase(newsRepository)
   }



   @Singleton
   @Provides
   fun provideGetUseCase(
      newsRepository: NewsRepository
   ): GetSavedNewsUseCase {
      return GetSavedNewsUseCase(newsRepository)
   }


}


















