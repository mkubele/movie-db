package com.kubele.moviedb.repository

import com.kubele.moviedb.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository


interface MovieRepository : JpaRepository<Movie, Long>