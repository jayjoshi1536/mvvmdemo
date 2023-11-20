package com.example.mvvm.repository

import com.varitas.gokulpos.tablet.model.Movie
import com.varitas.gokulpos.tablet.model.User


interface UserRepository {

    fun getUser(username: String, onSuccess: (user: User) -> Unit, onFailure: (t: Throwable) -> Unit)

    fun getAllMovies(onSuccess: (movies: List<Movie>) -> Unit, onFailure: (t: Throwable) -> Unit)
}