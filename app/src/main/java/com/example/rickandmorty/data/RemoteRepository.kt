package com.example.rickandmorty.data

import com.example.rickandmorty.model.Characters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class RemoteRepository {


    fun getCharacters(page:Int,returnOnSuccess:(Characters)->Unit,returnFailure:(String)->Unit){
        RetrofitClient.api.getCharacters(page).enqueue(object :Callback<Characters>{
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                response.isSuccessful
                returnOnSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                returnFailure(t.message?:"Unknown Error")
            }
        })
    }
}