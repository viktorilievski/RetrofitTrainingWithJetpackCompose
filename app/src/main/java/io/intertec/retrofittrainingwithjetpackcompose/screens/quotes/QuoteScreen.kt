package io.intertec.retrofittrainingwithjetpackcompose.screens.quotes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.intertec.retrofittrainingwithjetpackcompose.viewmodels.QuotesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun QuoteScreen(
  quotesViewModel: QuotesViewModel
) {
  val generatedQuote by quotesViewModel.generatedQuote.observeAsState("")
  val coroutineScope = rememberCoroutineScope()
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    QuoteComposable(
      generatedQuote = generatedQuote,
      generateNewQuote = {
        coroutineScope.launch(Dispatchers.IO) {
          quotesViewModel.generateRandomQuote()
        }
      }
    )
  }
}