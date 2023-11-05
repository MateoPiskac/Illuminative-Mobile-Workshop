package com.example.shakemate.networking

import com.example.shakemate.models.CocktailSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailsApiService {

@GET("search.php")
    suspend fun getCocktails(
   @Query("s") cocktailName: String
    ): CocktailSearchResponse
}