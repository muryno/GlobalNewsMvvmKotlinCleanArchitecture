package com.ubn.globalnewsmvvmarchitecture.domain.usecase

import com.ubn.globalnewsmvvmarchitecture.data.model.APIResponse
import com.ubn.globalnewsmvvmarchitecture.data.util.Resource
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
     suspend fun execute(searchQuery:String,country : String, page : Int): Resource<APIResponse> {
         return newsRepository.getSearchedNews(searchQuery,country,page)
     }
}