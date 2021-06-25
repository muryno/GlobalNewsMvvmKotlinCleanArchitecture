package com.ubn.globalnewsmvvmarchitecture.domain.usercase

import ApiResponse
import com.ubn.globalnewsmvvmarchitecture.data.utils.Resource
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepositoryInterface

class GetNewsHeadLineNewsCase(private var newsHeadline: NewsRepositoryInterface) {

    suspend fun execute(): Resource<ApiResponse>{
        return  newsHeadline.getNewsHeadlines()
    }
}