package com.example.moviedevapp.moviesapp

import android.app.Application
import com.example.moviedevapp.di.AppComponent
import com.example.moviedevapp.di.DaggerAppComponent

class MoviesApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .factory()
            .create(this)
    }
}