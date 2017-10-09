package com.task.currencyconverter.injection.module

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.ducere.fitnessband.repository.local.dao.UserDao
import com.ducere.fitnessband.repository.local.database.FitnessDatabase
import com.ducere.fitnessband.repository.remote.RemoteRepository
import com.task.currencyconverter.BuildConfig
import com.task.currencyconverter.application.MainApplication
import com.task.currencyconverter.injection.repository.remote.api.CommonApi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class ApplicationModule(private val application: MainApplication) {

    @Provides
    @Singleton
    fun provideApplication(): MainApplication = application

    @Provides
    @Singleton
    fun providePreferences(): SharedPreferences {
        return application.getSharedPreferences(BuildConfig.PREFERENCE_KEY, Context.MODE_PRIVATE)
    }

    @Provides
    fun provideNetworkInfo(): NetworkInfo? {
        val cm = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo
    }

    @Provides
    @Singleton
    fun provideHttpCache(): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val client = OkHttpClient.Builder()
                .cache(cache)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideCommonApi(retrofit: Retrofit): CommonApi = retrofit.create(CommonApi::class.java)

    @Provides
    @Singleton
    fun provideApiRepositoy(commonApi: CommonApi): RemoteRepository =
            RemoteRepository(commonApi)

    @Provides
    @Singleton
    fun provideDatabase(): FitnessDatabase {
        return Room.databaseBuilder(application,
                FitnessDatabase::class.java, BuildConfig.DB_NAME)
                .build();
    }

    @Singleton
    @Provides
    fun provideUserDao(database: FitnessDatabase): UserDao = database.userDao()
}