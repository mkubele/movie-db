package com.kubele.moviedb.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "movies")
data class Movie(
    @Column(name = "name", nullable = false)
    var name: String = "",

    @Column(name = "director")
    var director: String = "",

    @Column(name = "release_year")
    var releaseYear: Int = 0
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0
}
