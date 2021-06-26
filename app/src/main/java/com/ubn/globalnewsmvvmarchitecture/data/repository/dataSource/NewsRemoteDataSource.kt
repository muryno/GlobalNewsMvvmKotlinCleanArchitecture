package com.ubn.globalnewsmvvmarchitecture.data.repository.dataSource

import com.ubn.globalnewsmvvmarchitecture.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country : String, page : Int):Response<APIResponse>
}