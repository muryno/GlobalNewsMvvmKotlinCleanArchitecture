package com.ubn.globalnewsmvvmarchitecture.domain.usecase

import com.ubn.globalnewsmvvmarchitecture.data.model.Article
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
  suspend fun execute(article: Article)=newsRepository.saveNews(article)
}