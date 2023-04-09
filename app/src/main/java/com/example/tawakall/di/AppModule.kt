package com.example.tawakall.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.tawakall.common.Constants
import com.example.tawakall.data.source.local.dao.DatabaseHadith
import com.example.tawakall.data.source.local.dao.HadithDao
import com.example.tawakall.data.source.remote.HadithApi
import com.example.tawakall.data.source.repository.HadithRepositroyImpl
import com.example.tawakall.domain.repository.HadithRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideHadithRepository(api: HadithApi,dao: HadithDao): HadithRepository {
        return HadithRepositroyImpl(api,dao)
    }


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, DatabaseHadith::class.java, "hadith_database").build()

    @Provides
    @Singleton
    fun provideDao(db: DatabaseHadith):HadithDao{
        return db.hadithDao()
    }
}