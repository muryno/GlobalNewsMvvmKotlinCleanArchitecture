package com.ubn.globalnewsmvvmarchitecture.presentation.di

import android.app.Application
import com.ubn.globalnewsmvvmarchitecture.domain.usecase.GetNewsHeadlinesUseCase
import com.ubn.globalnewsmvvmarchitecture.domain.usecase.GetSavedNewsUseCase
import com.ubn.globalnewsmvvmarchitecture.domain.usecase.GetSearchedNewsUseCase
import com.ubn.globalnewsmvvmarchitecture.domain.usecase.SaveNewsUseCase
import com.ubn.globalnewsmvvmarchitecture.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
  fun provideNewsViewModelFactory(
     application: Application,
     getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
     getSearchedNewsUseCase : GetSearchedNewsUseCase,

     saveNewsUseCase: SaveNewsUseCase,
     getSavedNewsUseCase: GetSavedNewsUseCase
  ): NewsViewModelFactory {
      return NewsViewModelFactory(
          application,
          getNewsHeadlinesUseCase,
          getSearchedNewsUseCase,
        saveNewsUseCase,
          getSavedNewsUseCase
      )
  }
}








