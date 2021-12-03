package com.kubele.moviedb.service.impl

import com.kubele.moviedb.entity.Movie
import com.kubele.moviedb.repository.MovieRepository
import com.kubele.moviedb.service.MovieService
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(movieRepository: MovieRepository) : MovieService {
    private val movieRepository: MovieRepository

    override fun allMovies(): List<Movie> {
        return movieRepository.findAll() }

    override fun saveMovie(movie: Movie): Movie {
        return movieRepository.save<Movie>(movie)
    }

    override fun getMovieById(id: Long): Movie {
        return movieRepository.findById(id).get()
    }

    override fun updateMovie(movie: Movie): Movie {
        return movieRepository.save<Movie>(movie)
    }

    override fun deleteMovieById(id: Long) {
        movieRepository.deleteById(id)
    }

    init {
        this.movieRepository = movieRepository
    }
}