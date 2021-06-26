package com.ubn.globalnewsmvvmarchitecture.data.repository.dataSourceImpl

import com.ubn.globalnewsmvvmarchitecture.data.db.ArticleDAO
import com.ubn.globalnewsmvvmarchitecture.data.model.Article
import com.ubn.globalnewsmvvmarchitecture.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(private  val articleDAO: ArticleDAO) : NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDAO.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
      return  articleDAO.getAllArticles()
    }
}