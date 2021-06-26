package com.ubn.globalnewsmvvmarchitecture.domain.repository

import com.ubn.globalnewsmvvmarchitecture.data.model.APIResponse
import com.ubn.globalnewsmvvmarchitecture.data.model.Article
import com.ubn.globalnewsmvvmarchitecture.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository{

      suspend fun getNewsHeadlines(country : String, page : Int): Resource<APIResponse>
      suspend fun getSearchedNews(searchQuery:String,country : String, page : Int) : Resource<APIResponse>
      suspend fun saveNews(article: Article)
      suspend fun deleteNews(article: Article)
      fun getSavedNews(): Flow<List<Article>>




}