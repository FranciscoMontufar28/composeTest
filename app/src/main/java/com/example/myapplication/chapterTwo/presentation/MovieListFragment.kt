package com.example.myapplication.chapterTwo.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.chapterTwo.presentation.components.CardMovie
import com.example.myapplication.chapterTwo.viewmodel.MovieViewModel

class MovieListFragment : Fragment() {

    lateinit var movieListViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        movieListViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        return ComposeView(requireContext()).apply {
            setContent {
                val data = movieListViewModel.movieMutableState.value
                LazyColumn{
                    itemsIndexed(
                        items = data
                    ){ index, item ->
                        CardMovie(movie = item, onClickCard = {  })
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieListViewModel.getPopularMovies()
    }
}