package com.vitorota.pokemontcg2.data.api.schema

import com.google.gson.annotations.SerializedName

data class ListCardResponseSchema(
    @SerializedName("data")
    val data: List<CardSchema>
)