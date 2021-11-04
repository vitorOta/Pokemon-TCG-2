package com.vitorota.pokemontcg2.domain.usecase

import com.vitorota.pokemontcg2.domain.model.Card

interface SearchCardUseCase {
    suspend fun search(query: String): List<Card>
}