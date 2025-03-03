package com.mitkod.kotlindaggerexample.di

import com.mitkod.kotlindaggerexample.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}