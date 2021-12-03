package com.kubele.moviedb.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import com.kubele.moviedb.service.MovieService
import org.springframework.web.bind.annotation.GetMapping
import com.kubele.moviedb.entity.Movie
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable

@Controller
class MovieController(private val movieService: MovieService) {
    // handler method to handle list movies and return mode and view
    @GetMapping("/movies")
    fun listMovies(model: Model): String {
        model.addAttribute("movies", movieService.allMovies())
        return "movies"
    }

    @GetMapping("/movies/new")
    fun createMovieForm(model: Model): String {

        // create movie object to hold movie form data
        val movie = Movie()
        model.addAttribute("movie", movie)
        return "create_movie"
    }

    @PostMapping("/movies")
    fun saveMovie(@ModelAttribute("movie") movie: Movie): String {
        movieService.saveMovie(movie)
        return "redirect:/movies"
    }

    @GetMapping("/movies/edit/{id}")
    fun editMovieForm(@PathVariable id: Long, model: Model): String {
        model.addAttribute("movie", movieService.getMovieById(id))
        return "edit_movie"
    }

    @PostMapping("/movies/{id}")
    fun updateMovie(@PathVariable id: Long, @ModelAttribute("movie") movie: Movie, model: Model): String {
        val existingMovie = movieService.getMovieById(id)
        existingMovie.id = id
        existingMovie.name = movie.name
        existingMovie.director = movie.director
        existingMovie.releaseYear = movie.releaseYear
        movieService.updateMovie(existingMovie)
        return "redirect:/movies"
    }

    @GetMapping("/movies/{id}")
    fun deleteMovie(@PathVariable id: Long): String {
        movieService.deleteMovieById(id)
        return "redirect:/movies"
    }
}