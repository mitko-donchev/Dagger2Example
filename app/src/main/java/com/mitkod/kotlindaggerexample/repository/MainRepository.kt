package com.mitkod.kotlindaggerexample.repository

import androidx.lifecycle.LiveData
import com.mitkod.kotlindaggerexample.data.api.ApiService
import com.mitkod.kotlindaggerexample.model.User
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    var job: CompletableJob? = null

    fun getUser(userId: String): LiveData<User> {
        job = Job()
        return object : LiveData<User>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(Dispatchers.IO + theJob).launch {
                        val user = apiService.getUser(userId)
                        withContext(Dispatchers.Main) {
                            value = user
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs() = job?.cancel()
}