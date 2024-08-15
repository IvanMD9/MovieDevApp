package com.example.newsdevapp.newsapp

import android.app.Application
import com.example.newsdevapp.di.AppComponent
import com.example.newsdevapp.di.DaggerAppComponent
import com.google.firebase.FirebaseApp

class NewsApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .factory()
            .create(this)

        FirebaseApp.initializeApp(this)
    }
}