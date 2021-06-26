package com.ubn.globalnewsmvvmarchitecture.presentation.di

import com.ubn.globalnewsmvvmarchitecture.data.db.ArticleDAO
import com.ubn.globalnewsmvvmarchitecture.data.repository.dataSource.NewsLocalDataSource
import com.ubn.globalnewsmvvmarchitecture.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun providerNewsLocalDataSource( articleDAO: ArticleDAO) : NewsLocalDataSource{
        return NewsLocalDataSourceImpl(articleDAO)
    }
}