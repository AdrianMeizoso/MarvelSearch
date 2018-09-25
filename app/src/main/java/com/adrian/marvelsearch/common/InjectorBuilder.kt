package com.adrian.marvelsearch.common

import com.adrian.marvelsearch.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class InjectorBuilder {

    @ContributesAndroidInjector
    @PerActivity
    abstract fun bindMainActivity (): MainActivity
}