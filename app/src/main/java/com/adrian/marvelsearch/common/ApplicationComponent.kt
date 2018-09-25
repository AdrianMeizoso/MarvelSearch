package com.adrian.marvelsearch.common

import com.adrian.marvelsearch.MarvelSearchApp
import dagger.Component
import javax.inject.Singleton
import dagger.BindsInstance
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [AppModule::class, AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class, InjectorBuilder::class])
interface ApplicationComponent : AndroidInjector<MarvelSearchApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MarvelSearchApp): Builder
        fun build(): ApplicationComponent
    }

    override fun inject(app: MarvelSearchApp)
}
