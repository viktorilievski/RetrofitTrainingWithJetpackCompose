package io.intertec.retrofittrainingwithjetpackcompose.network

import io.intertec.retrofittrainingwithjetpackcompose.data.models.Quote
import io.intertec.retrofittrainingwithjetpackcompose.data.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {

  @GET("/quotes")
  suspend fun getQuotes(): Response<QuoteList>

  @GET("/random")
  suspend fun getRandomQuote(): Response<Quote>
}