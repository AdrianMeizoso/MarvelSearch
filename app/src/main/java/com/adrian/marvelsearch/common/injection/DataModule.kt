package com.adrian.marvelsearch.common.injection

import com.adrian.marvelsearch.main.HeroesRepository
import com.adrian.marvelsearch.main.datasource.HeroesApiDataSource
import com.adrian.marvelsearch.main.datasource.HeroesDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    companion object {
        const val BASE_URL = "https://api.example.com"
    }

    @Provides
    @Singleton
    fun bindOkHttpClient(): OkHttpClient = OkHttpClient()

    @Provides
    @Singleton
    fun bindRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()

    @Provides
    @Singleton
    fun bindHeroesApiDataSource(retrofit: Retrofit): HeroesApiDataSource
            = retrofit.create(HeroesApiDataSource::class.java)

    @Provides
    @Singleton
    fun bindHeroesRepository(heroesApiDataSource: HeroesApiDataSource): HeroesDataSource
            = HeroesRepository(heroesApiDataSource)
}