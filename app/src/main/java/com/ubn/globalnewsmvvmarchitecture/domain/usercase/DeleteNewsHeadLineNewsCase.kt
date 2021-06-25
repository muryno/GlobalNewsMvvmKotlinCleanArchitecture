package com.ubn.globalnewsmvvmarchitecture.domain.usercase

import Articles
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepositoryInterface

class DeleteNewsHeadLineNewsCase(private var newsHeadline: NewsRepositoryInterface) {
    suspend fun execute(article: Articles) = newsHeadline.deleteNews(article)
}