package com.kubele.moviedb

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MovieDatabaseApplication

fun main(args: Array<String>) {
    SpringApplication.run(MovieDatabaseApplication::class.java, *args)
}
