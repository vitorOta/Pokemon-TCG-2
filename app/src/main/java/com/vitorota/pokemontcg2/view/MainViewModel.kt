package com.vitorota.pokemontcg2.view

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitorota.pokemontcg2.data.ApiClientBuilder
import com.vitorota.pokemontcg2.data.api.PokemonTCGApi
import com.vitorota.pokemontcg2.data.repository.CardRepositoryImpl
import com.vitorota.pokemontcg2.domain.usecase.SearchCardUseCase
import com.vitorota.pokemontcg2.domain.usecase.SearchCardUseCaseImpl
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private val useCase: SearchCardUseCase = SearchCardUseCaseImpl(
        CardRepositoryImpl(
            ApiClientBuilder.createApi(PokemonTCGApi::class.java)
        )
    )

    fun searchByName(name: String) {
        viewModelScope.launch {
            try {
                val response = useCase.search(name)
                Log.d("xpto", "$response")
            } catch (e: Exception) {
                Log.e("xpto", "erro: $e")
            }

        }
    }
}