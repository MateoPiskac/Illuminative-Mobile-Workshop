package com.example.shakemate.models

import com.example.shakemate.data.Cocktail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CocktailSearchResponse (
    @SerialName("drinks") val cocktails: List<Cocktail>?
)

@Serializable
data class CocktailSearch(
    @SerialName("strDrink") val name: String?,
)