package com.ubn.globalnewsmvvmarchitecture.domain.usecase

import com.ubn.globalnewsmvvmarchitecture.data.model.Article
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}