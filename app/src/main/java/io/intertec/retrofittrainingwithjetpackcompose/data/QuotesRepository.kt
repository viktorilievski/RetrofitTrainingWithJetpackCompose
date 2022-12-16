package io.intertec.retrofittrainingwithjetpackcompose.data

import dagger.hilt.android.scopes.ViewModelScoped
import io.intertec.retrofittrainingwithjetpackcompose.network.QuotesApi
import javax.inject.Inject

@ViewModelScoped
class QuotesRepository @Inject constructor(
  private val quotesApi: QuotesApi
) {
  suspend fun generateRandomQuote(): String {
    return quotesApi.getRandomQuote().body()?.content ?: ""
  }
}