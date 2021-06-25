package com.ubn.globalnewsmvvmarchitecture.domain.usercase

import ApiResponse
import com.ubn.globalnewsmvvmarchitecture.data.utils.Resource
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepositoryInterface

class GetSearchedNewsHeadLineNewsCase(private var newsHeadline: NewsRepositoryInterface) {

    suspend fun execute(searchedQuery: String) : Resource<ApiResponse>{
      return  newsHeadline.getSearchedNews(searchedQuery)
    }

}