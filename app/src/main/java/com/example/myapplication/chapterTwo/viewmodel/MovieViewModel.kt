package com.example.myapplication.chapterTwo.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.chapterTwo.data.ResultEntity
import com.example.myapplication.chapterTwo.retrofit.RetrofitModule
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    var movieMutableState: MutableState<List<ResultEntity>> = mutableStateOf(ArrayList())
    val query =  mutableStateOf("")

    fun getPopularMovies() {
        viewModelScope.launch {
            Log.e("Carolina", "This is the start scope")
            val movies = RetrofitModule.getService().getPopularMovies()
            movies.let {
                Log.e("Carolina", "This is the result ${it.results}")
            }
            movieMutableState.value = movies.results
        }
    }

    fun changeTextValue(value:String) {
        this.query.value = value
    }
}