package com.ubn.globalnewsmvvmarchitecture.domain.usercase

import Articles
import com.ubn.globalnewsmvvmarchitecture.domain.repository.NewsRepositoryInterface
import kotlinx.coroutines.flow.Flow

class GetSavedNewsHeadLineNewsCase(private var newsHeadline: NewsRepositoryInterface) {


    fun execute(): Flow<List<Articles>>{
        return  newsHeadline.fetchSavedNews()
    }
}