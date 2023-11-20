package com.example.mvvm.api

import com.varitas.gokulpos.tablet.model.Movie
import com.varitas.gokulpos.tablet.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiClient {

    @GET("users/{user}") fun getUser(@Path("user") user : String) : Call<User>

    @GET("movielist.json") fun getAllMovies() : Call<List<Movie>>

//    @POST(Default.api + Default.version1 + Default.apiStoreBasic + "updatestatus") fun updateStoreStatus(@Body req : StoreUpdate) : Call<APIResponse>
}