package com.example.songapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.songapi.model.SearchResult
import com.example.songapi.model.Song
import com.example.songapi.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SongViewModel : ViewModel() {
    val songList = MutableLiveData<List<Song>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String?>()

    fun searchSongs(query: String) {
        loading.value = true
        RetrofitInstance.api.searchSongs(query).enqueue(object : Callback<SearchResult> {
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                loading.value = false
                if (response.isSuccessful) {
                    songList.value = response.body()?.data ?: emptyList()
                } else {
                    error.value = "Error: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                loading.value = false
                error.value = "Failure: ${t.message}"
            }
        })
    }
}
