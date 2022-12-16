package io.intertec.retrofittrainingwithjetpackcompose.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitHelper {

  val baseUrl = "https://api.quotable.io/"

  @Singleton
  @Provides
  fun getInstance(): Retrofit {
    return Retrofit.Builder().baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  @Provides
  @Singleton
  fun provideQuotesApi(retrofit: Retrofit): QuotesApi {
    return retrofit.create(QuotesApi::class.java)
  }
}