package com.example.rickandmorty.data


import com.example.rickandmorty.model.Characters
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface  RickAndMortyApi {

    @GET("/api/character/")
    fun getCharacters(
        @Query("page") page: Int
    ): Call<Characters>

}