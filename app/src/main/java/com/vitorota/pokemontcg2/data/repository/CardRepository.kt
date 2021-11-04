package com.vitorota.pokemontcg2.data.repository

import com.vitorota.pokemontcg2.domain.model.Card

interface CardRepository {
    suspend fun searchCardByName(name: String): List<Card>
}