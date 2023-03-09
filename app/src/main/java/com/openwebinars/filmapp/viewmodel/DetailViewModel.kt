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
class DetailViewModel @Inject constructor(
    private val favoritesRepository : FavoritesRepository
) :ViewModel()  {


    val isFavoriteData = MutableLiveData<Boolean>()

    fun onViewCreated(film: Film?){
        film?.let{
            viewModelScope.launch {
                val exist = favoritesRepository.exist(film)
                isFavoriteData.postValue(exist)
            }
        }



    }

    fun onClickFavorite(film: Film){
        viewModelScope.launch {
            if(favoritesRepository.exist(film)){
                favoritesRepository.remove(film)
                isFavoriteData.postValue(false)
            }else{
                favoritesRepository.save(film)
                isFavoriteData.postValue(true)
            }
        }
    }
}