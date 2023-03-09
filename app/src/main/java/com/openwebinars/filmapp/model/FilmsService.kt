package com.openwebinars.filmapp.model

import com.openwebinars.filmapp.data.api.FilmApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilmsService @Inject constructor(
    private val api: FilmApiClient
) {

    suspend fun get() : List<Film> {
       return withContext(Dispatchers.IO){
            val response = api.getNewFilms()
           response.body() ?: emptyList()


       }
    }

}

