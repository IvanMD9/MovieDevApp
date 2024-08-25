package com.example.core.analytics.event

import android.os.Bundle

abstract class AnalyticsEvent(
    open val name: String,
    open val bundle: Bundle,
)