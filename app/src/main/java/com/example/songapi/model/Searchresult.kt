package com.example.songapi.model

data class SearchResult(
    val data: List<Song>
)

data class Song(
    val title: String,
    val artist: Artist,
    val album: Album
)

data class Artist(
    val name: String
)

data class Album(
    val cover_medium: String
)