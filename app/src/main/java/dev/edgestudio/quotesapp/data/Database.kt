package dev.edgestudio.quotesapp.data

class Database private constructor(){

    val quoteDao = QuoteDao()

    companion object{
        @Volatile private var instance: Database? = null

        fun getInstance() =
            instance?: synchronized(this){
                instance?: Database().also { instance = it }
            }
    }
}