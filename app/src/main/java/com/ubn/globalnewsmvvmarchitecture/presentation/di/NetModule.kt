package com.ubn.globalnewsmvvmarchitecture.presentation.di


import com.ubn.globalnewsmvvmarchitecture.BuildConfig
import com.ubn.globalnewsmvvmarchitecture.data.api.NewsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetModule {



    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {





        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .writeTimeout(25,TimeUnit.SECONDS)

            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")


                    .build()
                chain.proceed(newRequest)

            }.addInterceptor(interceptor).build()


         return Retrofit.Builder()
             .addConverterFactory(GsonConverterFactory.create())
             .baseUrl(BuildConfig.BASE_URL)
             .client(client)
             .build()
    }

    @Singleton
    @Provides
    fun provideNewsAPIService(retrofit: Retrofit): NewsAPIService {
        return retrofit.create(NewsAPIService::class.java)
    }



}













