package com.ubn.globalnewsmvvmarchitecture.domain.repository

import ApiResponse
import Articles
import com.ubn.globalnewsmvvmarchitecture.data.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepositoryInterface {

    suspend fun getNewsHeadlines():Resource<ApiResponse>

    suspend fun getSearchedNews(searchQuery:String) : Resource<ApiResponse>
    suspend fun saveNews(article: Articles)
    suspend fun deleteNews(article: Articles)

    //flow api is a way to handle stream of data asynchronously in coroutine
    //we don't need suspense since we it is live data and we don't want to pause stream
     fun fetchSavedNews(): Flow<List<Articles>>

}