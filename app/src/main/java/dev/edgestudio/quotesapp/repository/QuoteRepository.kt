package dev.edgestudio.quotesapp.repository

import dev.edgestudio.quotesapp.data.QuoteDAO
import dev.edgestudio.quotesapp.model.Quote

class QuoteRepository private constructor(private val quoteDao: QuoteDAO){

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object{
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: QuoteDAO) =
            instance?: synchronized(this){
                instance?: QuoteRepository(quoteDao).also { instance = it }
            }
    }
}