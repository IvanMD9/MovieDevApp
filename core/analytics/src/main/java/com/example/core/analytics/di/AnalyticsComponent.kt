package com.example.core.analytics.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsModule::class])
interface AnalyticsComponent: AnalyticsApi