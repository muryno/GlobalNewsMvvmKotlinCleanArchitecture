package com.ubn.globalnewsmvvmarchitecture.data.repository.dataSource

import com.ubn.globalnewsmvvmarchitecture.data.model.APIResponse
import retrofit2.Response


//talk to remote server or database
interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country : String, page : Int):Response<APIResponse>

    suspend fun getSearchedTopHeadlines(q: String, country : String, page : Int):Response<APIResponse>


}