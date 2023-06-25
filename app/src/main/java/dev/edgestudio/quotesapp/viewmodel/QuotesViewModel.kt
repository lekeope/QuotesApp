package dev.edgestudio.quotesapp.viewmodel

import androidx.lifecycle.ViewModel
import dev.edgestudio.quotesapp.pojo.Quote
import dev.edgestudio.quotesapp.repository.QuoteRepository

class QuotesViewModel (private  val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}