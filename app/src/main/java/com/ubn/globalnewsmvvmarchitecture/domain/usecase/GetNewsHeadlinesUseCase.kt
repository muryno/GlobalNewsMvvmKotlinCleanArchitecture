package com.ubn.globalnewsmvvmarchitecture.domain.usecase

import com.ubn.globalnewsmvvmarchitecture.data.model.APIResponse
import com.ubn.globalnewsmvvmarchitecture.data.util.Resource
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country : String, page : Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country,page)
    }
}