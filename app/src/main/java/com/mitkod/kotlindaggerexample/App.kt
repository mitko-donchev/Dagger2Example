package com.mitkod.kotlindaggerexample

import android.app.Application
import com.mitkod.kotlindaggerexample.di.ApplicationComponent
import com.mitkod.kotlindaggerexample.di.DaggerApplicationComponent

class App: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}