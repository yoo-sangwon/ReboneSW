package com.example.rebonesw

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ReboneApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}