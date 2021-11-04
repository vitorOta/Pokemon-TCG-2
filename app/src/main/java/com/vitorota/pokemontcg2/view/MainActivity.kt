package com.vitorota.pokemontcg2.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.vitorota.pokemontcg2.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private val bSearch: Button by lazy {
        findViewById(R.id.main_bSearch)
    }

    private val etName: EditText by lazy {
        findViewById(R.id.main_etName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get()

        setContentView(R.layout.activity_main)

        bSearch.setOnClickListener {
            val nameToSearch = etName.text.toString()
            viewModel.searchByName(nameToSearch)
        }
    }
}