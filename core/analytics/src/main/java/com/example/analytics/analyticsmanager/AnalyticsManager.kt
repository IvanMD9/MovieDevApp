package com.example.analytics.analyticsmanager

import com.example.analytics.event.AnalyticsEvent

interface AnalyticsManager {

    fun logEvent(event: AnalyticsEvent)
}