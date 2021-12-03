package com.kubele.moviedb.service

import com.kubele.moviedb.entity.Movie

interface MovieService {
    fun allMovies(): List<Movie>
    fun saveMovie(movie: Movie): Movie
    fun getMovieById(id: Long): Movie
    fun updateMovie(movie: Movie): Movie
    fun deleteMovieById(id: Long)
}