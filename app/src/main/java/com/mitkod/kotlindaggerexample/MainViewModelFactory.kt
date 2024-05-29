package com.mitkod.kotlindaggerexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mitkod.kotlindaggerexample.repository.MainRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val mainRepository: MainRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(mainRepository) as T
    }
}