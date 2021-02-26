package com.example.myapplication.chapterTwo.util

enum class MovieCategories(val value: String) {
    ACTION("Action"),
    COMEDY("Comedy"),
    KIDS("Kids"),
    HORROR("Horror"),
    DRAMA("Drama"),
    DOCUMENTARIES("Documentaries"),
    ANIMATION("Animation")
}

fun getAllMovieCategories(): List<MovieCategories> {
    return listOf(
        MovieCategories.ACTION,
        MovieCategories.COMEDY,
        MovieCategories.KIDS,
        MovieCategories.HORROR,
        MovieCategories.DRAMA,
        MovieCategories.DOCUMENTARIES,
        MovieCategories.ANIMATION
    )
}

fun getMovieCategory(value:String):MovieCategories?{
    val map = MovieCategories.values().associateBy(MovieCategories::value)
    return map[value]
}