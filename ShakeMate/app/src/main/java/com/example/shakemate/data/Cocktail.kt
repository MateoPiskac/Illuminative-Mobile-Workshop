package com.example.shakemate.data

import java.io.Serializable
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Cocktail(
    @SerialName("idDrink") val id: String,
    @SerialName("strDrink") val name: String,
    @SerialName("strDrinkThumb") val image: String,
    @SerialName("strAlcoholic") val alcoholic: String,
    @SerialName("strGlass") val glass: String,
    @SerialName("strInstructions") val instructions: String?,
    @SerialName("strIngredient1") val ingredient1: String?,
    @SerialName("strIngredient2") val ingredient2: String?,
    @SerialName("strIngredient3") val ingredient3: String?,
    @SerialName("strIngredient4") val ingredient4: String?,
    @SerialName("strIngredient5") val ingredient5: String?,
    @SerialName("strIngredient6") val ingredient6: String?,
    @SerialName("strMeasure1") val measure1: String?,
    @SerialName("strMeasure2") val measure2: String?,
    @SerialName("strMeasure3") val measure3: String?,
    @SerialName("strMeasure4") val measure4: String?,
    @SerialName("strMeasure5") val measure5: String?,
    @SerialName("strMeasure6") val measure6: String?,
) : Serializable