package com.vitorota.pokemontcg2.domain.usecase

import com.vitorota.pokemontcg2.data.repository.CardRepository
import com.vitorota.pokemontcg2.domain.model.Card

class SearchCardUseCaseImpl(private val repo: CardRepository) : SearchCardUseCase {
    override suspend fun search(name: String): List<Card> {
        return repo.searchCardByName(name)
    }
}