package com.adrian.marvelsearch

import com.adrian.marvelsearch.common.injection.ApplicationComponent
import com.adrian.marvelsearch.common.injection.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MarvelSearchApp : DaggerApplication() {

    private val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        applicationComponent.inject(this)
        return applicationComponent
    }
}