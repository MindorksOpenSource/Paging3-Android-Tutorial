package com.mindorks.example.paging3.data

import com.mindorks.example.paging3.data.response.ApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("api/users")
    suspend fun getListData(@Query("page") pageNumber: Int): Response<ApiResponse>

    companion object {

        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        fun getApiService() = Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(APIService::class.java)
    }
}
