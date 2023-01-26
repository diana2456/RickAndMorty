package com.example.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class Characters(@SerializedName("results")
                      val results: List<ResultsItem>?,
                      @SerializedName("info")
                      val info: Info
)

