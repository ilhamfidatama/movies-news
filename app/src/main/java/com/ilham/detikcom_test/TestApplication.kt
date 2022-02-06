package com.ilham.detikcom_test

import android.app.Application
import com.rommansabbir.networkx.NetworkXConfig
import com.rommansabbir.networkx.NetworkXProvider
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class TestApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
        val builder = NetworkXConfig.Builder()
            .withApplication(this)
            // You can disable speed meter if not required
            .withEnableSpeedMeter(false)
            .build()
        NetworkXProvider.enable(builder)
    }
}