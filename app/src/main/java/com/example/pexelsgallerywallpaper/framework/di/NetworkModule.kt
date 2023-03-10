package com.example.pexelsgallerywallpaper.framework.di

import com.example.pexelsgallerywallpaper.BuildConfig
import com.example.pexelsgallerywallpaper.framework.network.api.WallpapersApi
import com.example.pexelsgallerywallpaper.framework.network.interceptor.AuthorizationInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val TIMEOUT_SECONDS = 15L

    @Provides
    fun provideLoginInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    fun providesAuthorizationInterceptor(): AuthorizationInterceptor =
        AuthorizationInterceptor(BuildConfig.PRIVATE_KEY)

    @Provides
    fun providesOKHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authorization: AuthorizationInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authorization)
        .build()

    @Provides
    fun providerGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    fun providerConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Provides
    fun providerRetrofit(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory,
    ): WallpapersApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .addConverterFactory(converterFactory)
        .build()
        .create(WallpapersApi::class.java)
}