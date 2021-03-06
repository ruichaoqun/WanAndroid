package com.ruichaoqun.wanandroid.di

import android.content.Context
import com.google.gson.Gson
import com.ruichaoqun.wanandroid.data.ApiService
import com.ruichaoqun.wanandroid.data.DataRepository
import com.ruichaoqun.wanandroid.data.http.DefaultHttpRepository
import com.ruichaoqun.wanandroid.data.http.HttpRepository
import com.ruichaoqun.wanandroid.data.http.cookie.persistentcookiejar.PersistentCookieJar
import com.ruichaoqun.wanandroid.data.http.cookie.persistentcookiejar.cache.SetCookieCache
import com.ruichaoqun.wanandroid.data.http.cookie.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/3/9 18:26
 * @Description:    AppModule
 * @Version:        1.0
 */
@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApiService(client:OkHttpClient,gson:Gson): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context):OkHttpClient{
        return OkHttpClient.Builder()
            .cookieJar(PersistentCookieJar(SetCookieCache(),SharedPrefsCookiePersistor(context)))
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideGson():Gson{
        return Gson()
    }

    @Provides
    @Singleton
    fun provideHttpRepository(apiService: ApiService):HttpRepository{
        return DefaultHttpRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideDataRepository(httpRepository: HttpRepository):DataRepository{
        return DataRepository(httpRepository)
    }
}