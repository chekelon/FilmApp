package com.openwebinars.filmapp.model

import javax.inject.Inject

class NewFilmsRepository @Inject constructor(
     private val api : FilmsService
) {
     suspend fun get():List<Film> = api.get()

}


