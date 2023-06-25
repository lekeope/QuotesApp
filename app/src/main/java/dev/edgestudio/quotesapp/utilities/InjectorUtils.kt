package dev.edgestudio.quotesapp.utilities

import dev.edgestudio.quotesapp.data.Database
import dev.edgestudio.quotesapp.repository.QuoteRepository
import dev.edgestudio.quotesapp.viewmodel.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(Database.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}