package com.vitorota.pokemontcg2.data.repository

import com.vitorota.pokemontcg2.data.api.PokemonTCGApi
import com.vitorota.pokemontcg2.data.api.schema.CardSchema
import com.vitorota.pokemontcg2.data.api.schema.ListCardResponseSchema
import com.vitorota.pokemontcg2.domain.model.Card

class CardRepositoryImpl(private val api: PokemonTCGApi) : CardRepository {
    override suspend fun searchCardByName(name: String): List<Card> {
        val apiResponse = api.searchByName()
        return convertSchemaToDomain(apiResponse)
    }

    private fun convertSchemaToDomain(response: ListCardResponseSchema): List<Card> {
        val converted = response.data.map { cardSchema ->
            Card(
                id = cardSchema.id,
                name = cardSchema.name,
                imageUrl = cardSchema.images.large
            )
        }
        return converted
    }
}