package dev.edgestudio.quotesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.edgestudio.quotesapp.repository.QuoteRepository


class QuotesViewModelFactory (private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}