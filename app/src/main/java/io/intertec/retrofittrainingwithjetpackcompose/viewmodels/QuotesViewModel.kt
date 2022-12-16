package io.intertec.retrofittrainingwithjetpackcompose.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.intertec.retrofittrainingwithjetpackcompose.data.QuotesRepository
import io.intertec.retrofittrainingwithjetpackcompose.modules.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
  private val quotesRepository: QuotesRepository,
  @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

  private val _generatedQuote: MutableLiveData<String> = MutableLiveData()
  val generatedQuote: LiveData<String> = _generatedQuote

  init {
    viewModelScope.launch(ioDispatcher) {
      _generatedQuote.postValue(quotesRepository.generateRandomQuote())
    }
  }

  suspend fun generateRandomQuote() {
    _generatedQuote.postValue(quotesRepository.generateRandomQuote())
  }
}