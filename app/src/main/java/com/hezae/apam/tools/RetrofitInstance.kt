package com.hezae.apam.tools

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hezae.apam.tools.apis.AlbumApi
import com.hezae.apam.tools.apis.PictureApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val gson: Gson = GsonBuilder()
        .setLenient() // 设置宽松模式
        .create()
    private const val BASE_URL = "http://192.168.20.27:8000"
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }

    val pictureApi: PictureApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(PictureApi::class.java)
    }

    val albumApi: AlbumApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(AlbumApi::class.java)
    }


}