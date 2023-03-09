package com.openwebinars.filmapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openwebinars.filmapp.model.Film
import com.openwebinars.filmapp.model.NewFilmsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository : NewFilmsRepository
):ViewModel() {



    val newsLiveData = MutableLiveData<List<Film>>()
    val isLoadingLiveData = MutableLiveData<Boolean>()

    fun onViewCreated(){
        viewModelScope.launch {
            isLoadingLiveData.postValue(true)
            val news = repository.get()
            newsLiveData.postValue(news)
            isLoadingLiveData.postValue(false)
        }

    }
}