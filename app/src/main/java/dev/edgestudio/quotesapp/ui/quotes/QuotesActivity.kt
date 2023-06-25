package dev.edgestudio.quotesapp.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.edgestudio.quotesapp.databinding.ActivityQuotesBinding
import dev.edgestudio.quotesapp.pojo.Quote
import dev.edgestudio.quotesapp.utilities.InjectorUtils
import dev.edgestudio.quotesapp.viewmodel.QuotesViewModel

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI(binding)
    }
    private fun initUI(binding:ActivityQuotesBinding){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{ quote ->
                stringBuilder.append("$quote\n\n")
            }
            binding.textViewQuotes.text = stringBuilder.toString()
        })
        binding.buttonAddQuote.setOnClickListener {
            val quote = Quote(binding.editTextQuote.text.toString(),
                binding.editTextAuthor.text.toString())
            viewModel.addQuote(quote)
            binding.editTextQuote.setText("")
            binding.editTextAuthor.setText("")
        }
    }
}