package com.adrian.marvelsearch.common.injection

import com.adrian.marvelsearch.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class InjectorBuilder {

    @ContributesAndroidInjector
    @PerActivity
    abstract fun bindMainActivity(): MainActivity
}