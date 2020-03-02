package com.prempal.ringtail

import android.app.Application
import com.prempal.ringtail.di.AppContainer

/**
 * Created by prempal on 3/2/20.
 */
class RingtailApplication : Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer()
    }
}
