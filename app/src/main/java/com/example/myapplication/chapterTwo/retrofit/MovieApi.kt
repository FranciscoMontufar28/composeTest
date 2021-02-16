package com.example.myapplication.chapterTwo.retrofit

import com.example.myapplication.chapterTwo.data.MovieEntity
import com.example.myapplication.chapterTwo.util.KEY_VALUE
import com.example.myapplication.chapterTwo.util.POPULAR_PATCH
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET(POPULAR_PATCH)
    suspend fun getPopularMovies(@Query("api_key") key:String = KEY_VALUE): MovieEntity
}