package com.example.core.analytics.di

import com.example.core.analytics.analyticsmanager.AnalyticsManager
import com.example.core.analytics.analyticsmanager.AnalyticsManagerImpl
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface AnalyticsModule {

    @Singleton
    @Binds
    fun bindAnalyticsManager(impl: AnalyticsManagerImpl): AnalyticsManager

    companion object {

        @Singleton
        @Provides
        fun providesFirebaseAnalytics(): FirebaseAnalytics = Firebase.analytics
    }
}