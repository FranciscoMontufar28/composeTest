package com.example.myapplication.chapterTwo.data

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    val page: String,
    val results: List<ResultEntity>,
    @SerializedName("total_pages")
    val totalPages: String,
    @SerializedName("total_results")
    val totalResults: String
)

data class ResultEntity(
    val id: String,
    val title: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: String,
    @SerializedName("release_date")
    val releaseDate: String
)