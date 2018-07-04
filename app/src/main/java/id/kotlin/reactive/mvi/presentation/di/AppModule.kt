package id.kotlin.reactive.mvi.presentation.di

import dagger.Module
import dagger.Provides
import id.kotlin.reactive.mvi.BuildConfig
import id.kotlin.reactive.mvi.clazz
import id.kotlin.reactive.mvi.data.repository.NetworkService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(15, TimeUnit.SECONDS)
                        .writeTimeout(15, TimeUnit.SECONDS)
                        .retryOnConnectionFailure(true)
                        .addInterceptor(httpLoggingInterceptor)
                        .build()

    @Provides
    @Singleton
    fun providesNetworkService(okHttpClient: OkHttpClient): NetworkService =
            Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BuildConfig.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(clazz<NetworkService>())
}