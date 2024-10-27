package com.example.songapi.network
import com.example.songapi.model.SearchResult
import retrofit2.Call
import retrofit2.http.GET

import retrofit2.http.Query

interface DeezerApiService {
    @GET("search")
    fun searchSongs(
        @Query("q") query: String
    ): Call<SearchResult>
}