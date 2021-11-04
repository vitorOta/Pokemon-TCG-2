package com.vitorota.pokemontcg2.data.api.schema

import com.google.gson.annotations.SerializedName

data class CardSchema(
    @SerializedName("id")
    val id:String,
    @SerializedName("name")
    val name:String,
    @SerializedName("flavorText")
    val flavorText:String,
    @SerializedName("images")
    val images:CardImageSchema
)

data class CardImageSchema(
    val small:String,
    val large:String,
)