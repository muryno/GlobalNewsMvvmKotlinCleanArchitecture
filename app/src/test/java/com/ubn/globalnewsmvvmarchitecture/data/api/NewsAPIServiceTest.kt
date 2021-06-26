package com.ubn.globalnewsmvvmarchitecture.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NewsAPIServiceTest {


    private lateinit var newsAPIService : NewsAPIService
    private lateinit var mockWebServer : MockWebServer

    @Before
    fun setUp() {
        mockWebServer  = MockWebServer()
        newsAPIService = Retrofit.
        Builder().
        baseUrl(mockWebServer.url("")).
        addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsAPIService::class.java)
    }

    fun enqueueMockUpResponse(fileName:String){
        val inputStream = javaClass.classLoader?.getResourceAsStream(fileName)
        val source = inputStream?.source()?.buffer()

        val mockResponse =MockResponse()
        mockResponse.setBody(source!!.readString(Charsets.UTF_8))
        mockWebServer.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlinesFakeResponse(){
        runBlocking {
            enqueueMockUpResponse("newsApi.json")

            val respose = newsAPIService.getTopHeadlines(country = "us",page = 1).body()

            val predefineResponse  =   mockWebServer.takeRequest()

           assertThat(respose).isNotNull()
            assertThat(predefineResponse.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=66e93c8c73034ae7beed54f08e915c47")
        }
    }

    @Test
    fun getTopHeadline_receiveResponse_correctPageSize(){
        runBlocking {
            enqueueMockUpResponse("newsApi.json")
            val respose = newsAPIService.getTopHeadlines(country = "us",page = 1).body()
            val predefineResponse  =  respose!!.articles
            assertThat(predefineResponse.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadline_receiveResponse_getCorrectContent(){
        runBlocking {

            enqueueMockUpResponse("newsApi.json")
            val respose = newsAPIService.getTopHeadlines(country = "us",page = 1).body()
            val predefineResponse  =  respose!!.articles[0]
            assertThat(predefineResponse.author).isEqualTo("William K. Rashbaum, Ben Protess, Jonah E. Bromwich")
            assertThat(predefineResponse.title).isEqualTo("Trump Organization Could Face Criminal Charges in D.A. Inquiry - The New York Times")

        }
    }
}