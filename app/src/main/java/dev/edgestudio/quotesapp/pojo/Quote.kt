package dev.edgestudio.quotesapp.pojo

data class Quote (val text: String, val author: String){
    override fun toString() = "$text - $author"
}