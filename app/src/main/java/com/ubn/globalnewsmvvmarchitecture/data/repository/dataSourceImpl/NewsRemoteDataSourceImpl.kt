package com.ubn.globalnewsmvvmarchitecture.data.repository.dataSourceImpl

import com.ubn.globalnewsmvvmarchitecture.data.api.NewsAPIService
import com.ubn.globalnewsmvvmarchitecture.data.model.APIResponse
import com.ubn.globalnewsmvvmarchitecture.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
        private val newsAPIService: NewsAPIService
): NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country : String, page : Int): Response<APIResponse> {
          return newsAPIService.getTopHeadlines(country,page)
    }
}