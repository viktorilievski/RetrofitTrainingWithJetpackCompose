package io.intertec.retrofittrainingwithjetpackcompose.screens.quotes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.intertec.retrofittrainingwithjetpackcompose.ui.theme.RetrofitTrainingWithJetpackComposeTheme

@Composable
fun QuoteComposable(
  generatedQuote: String,
  generateNewQuote: () -> Unit
) {
  Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
    horizontalArrangement = Arrangement.Center
  ) {
    Text(text = generatedQuote, textAlign = TextAlign.Center)
  }
  Button(onClick = { generateNewQuote() }) {
    Text(text = "Generate New Quote")
  }
}

@Preview
@Composable
fun QuoteComposablePreview() {
  RetrofitTrainingWithJetpackComposeTheme {
    QuoteComposable(
      generatedQuote = "This is a random generated quote.",
      generateNewQuote = {}
    )
  }
}