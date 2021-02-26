package com.example.myapplication.chapterTwo.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.chapterTwo.presentation.components.CardMovie
import com.example.myapplication.chapterTwo.presentation.components.MovieCategoryChip
import com.example.myapplication.chapterTwo.util.getAllMovieCategories
import com.example.myapplication.chapterTwo.util.getMovieCategory
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
                //val query = remember { mutableStateOf("WonderWoman") }
                val query = movieListViewModel.query.value

                Column {
                    //TopAppBar(
                    Surface(
                        elevation = 8.dp
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth(0.9f)
                                        .padding(8.dp),
                                    value = query,
                                    onValueChange = {
                                        movieListViewModel.changeTextValue(it)
                                    },
                                    label = {
                                        Text(text = "Search")
                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Text,
                                        imeAction = ImeAction.Search
                                    ),
                                    leadingIcon = {
                                        Icon(Icons.Filled.Search, contentDescription = "")
                                    },
                                    onImeActionPerformed = { imeAction, softwareKeyboardController ->
                                        when (imeAction) {
                                            ImeAction.Search -> {
                                                Toast.makeText(
                                                    requireContext(),
                                                    query,
                                                    Toast.LENGTH_LONG
                                                ).show()
                                                softwareKeyboardController?.hideSoftwareKeyboard()
                                            }
                                        }
                                    },
                                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                                    backgroundColor = MaterialTheme.colors.surface
                                )
                            }
                            LazyRowFor(
                                items = getAllMovieCategories(),
                                modifier = Modifier.fillMaxWidth()
                            ) { category ->
                                MovieCategoryChip(
                                    category = category.value,
                                    onExecuteSearch = {
                                        movieListViewModel.changeTextValue(it)
                                    }
                                )
                            }
                        }
                    }

                    LazyColumn {
                        itemsIndexed(
                            items = data
                        ) { index, item ->
                            CardMovie(movie = item, onClickCard = {
                                //findNavController().navigate(R.id.action_see_movie_details)
                                findNavController().navigate(
                                    MovieListFragmentDirections.actionSeeMovieDetails(
                                        item.title
                                    )
                                )
                            })
                        }
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