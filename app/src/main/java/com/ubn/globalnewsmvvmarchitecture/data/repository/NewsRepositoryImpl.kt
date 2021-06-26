package com.ubn.globalnewsmvvmarchitecture.data.repository

import com.ubn.globalnewsmvvmarchitecture.data.model.APIResponse
import com.ubn.globalnewsmvvmarchitecture.data.model.Article
import com.ubn.globalnewsmvvmarchitecture.data.repository.dataSource.NewsRemoteDataSource
import com.ubn.globalnewsmvvmarchitecture.data.util.Resource
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
        private val newsRemoteDataSource: NewsRemoteDataSource
): NewsRepository {
    override suspend fun getNewsHeadlines(country : String, page : Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country,page))
    }

    private fun responseToResource(response:Response<APIResponse>): Resource<APIResponse> {
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }


    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}