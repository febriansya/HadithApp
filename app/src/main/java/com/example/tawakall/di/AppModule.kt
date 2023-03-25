package com.example.tawakall.di

import com.example.tawakall.common.Constants
import com.example.tawakall.persentation.screen.data.remote.HadithApi
import com.example.tawakall.persentation.screen.data.repository.HadithRepositroyImpl
import com.example.tawakall.domain.repository.HadithRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideHadithApi(): HadithApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HadithApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHadithRepository(api: HadithApi): HadithRepository {
        return HadithRepositroyImpl(api)
    }
}