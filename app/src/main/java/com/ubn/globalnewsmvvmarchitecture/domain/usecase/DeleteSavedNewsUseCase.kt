package com.ubn.globalnewsmvvmarchitecture.domain.usecase

import com.ubn.globalnewsmvvmarchitecture.data.model.Article
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article)=newsRepository.deleteNews(article)
}