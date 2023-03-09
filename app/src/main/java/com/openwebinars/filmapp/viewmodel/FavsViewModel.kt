package com.openwebinars.filmapp.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openwebinars.filmapp.model.FavoritesRepository
import com.openwebinars.filmapp.model.Film
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavsViewModel @Inject constructor(
    private val favsRepository: FavoritesRepository
):ViewModel() {

    val favsLiveData = MutableLiveData<List<Film>>()
    val isLoading = MutableLiveData<Boolean>()


    fun onViewCreated() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val favs = favsRepository.get()
            favsLiveData.postValue(favs)
            isLoading.postValue(false)
        }
    }
}