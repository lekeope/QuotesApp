package dev.edgestudio.quotesapp.repository

import dev.edgestudio.quotesapp.data.QuoteDao
import dev.edgestudio.quotesapp.pojo.Quote

class QuoteRepository private constructor(private val quoteDao: QuoteDao){

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object{
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: QuoteDao) =
            instance?: synchronized(this){
                instance?: QuoteRepository(quoteDao).also { instance = it }
            }
    }
}