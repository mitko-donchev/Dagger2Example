package com.mitkod.kotlindaggerexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.mitkod.kotlindaggerexample.model.User
import com.mitkod.kotlindaggerexample.repository.MainRepository

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val userId: MutableLiveData<String> = MutableLiveData()

    val user: LiveData<User> = userId.switchMap {
        mainRepository.getUser(it)
    }

    fun setUserId(newUserId: String) {
        if (userId.value == newUserId) return
        userId.value = newUserId
    }

    fun cancelJobs() = mainRepository.cancelJobs()
}