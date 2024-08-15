package com.example.analytics.analyticsmanager

import android.util.Log
import com.example.analytics.event.AnalyticsEvent
import com.google.firebase.analytics.FirebaseAnalytics
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnalyticsManagerImpl @Inject constructor(
    private val analytics: FirebaseAnalytics,
) : AnalyticsManager {

    companion object {
        private const val MAX_VALUE_LEN = 100
        internal const val ANALYTICS_MANAGER_TAG = "ANALYTICS_MANAGER_NEWS"
    }

    override fun logEvent(event: AnalyticsEvent) {
        val data = event.bundle
        Log.d(
            ANALYTICS_MANAGER_TAG,
            "${event.name} ${
                event.bundle.keySet()
                    .joinToString(", ", "{", "}") { key ->
                        "$key=${event.bundle[key]}"
                    }
            }",
        )
        for (key in data.keySet()) {
            val value = data[key].toString()
            if (value.length >= MAX_VALUE_LEN) {
                data.putString(key, value.subSequence(0, MAX_VALUE_LEN).toString())
            }
        }
        analytics.logEvent(event.name, event.bundle)
    }
}