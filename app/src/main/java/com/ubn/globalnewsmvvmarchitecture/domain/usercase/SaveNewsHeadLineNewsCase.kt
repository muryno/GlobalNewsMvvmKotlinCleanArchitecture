package com.ubn.globalnewsmvvmarchitecture.domain.usercase

import Articles
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepositoryInterface

class SaveNewsHeadLineNewsCase(private var newsHeadline: NewsRepositoryInterface) {
    suspend fun execute(article: Articles) = newsHeadline.saveNews(article)

}