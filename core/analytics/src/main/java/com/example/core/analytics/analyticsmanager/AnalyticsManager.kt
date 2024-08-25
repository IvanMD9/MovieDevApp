package com.example.core.analytics.analyticsmanager

import com.example.core.analytics.event.AnalyticsEvent

interface AnalyticsManager {

    fun logEvent(event: AnalyticsEvent)
}