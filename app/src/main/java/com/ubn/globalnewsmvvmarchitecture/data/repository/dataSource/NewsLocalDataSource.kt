package com.ubn.globalnewsmvvmarchitecture.data.repository.dataSource

import com.ubn.globalnewsmvvmarchitecture.data.model.Article
import kotlinx.coroutines.flow.Flow


interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)

    fun getSavedArticles(): Flow<List<Article>>
}