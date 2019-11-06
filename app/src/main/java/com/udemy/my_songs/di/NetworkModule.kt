package com.udemy.my_songs.di

import com.udemy.my_songs.BuildConfig
import com.udemy.my_songs.network.NetworkService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideNetworkService(get()) }
    single { provideRetrofit(get()) }
}

fun provideNetworkService(retrofit: Retrofit): NetworkService =
    retrofit.create(NetworkService::class.java)

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun provideOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient()
        .newBuilder()
        .addInterceptor(logging)
        .build()
}