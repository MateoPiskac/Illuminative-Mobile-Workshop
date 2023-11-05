package com.example.shakemate.ui.searchCocktails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shakemate.data.Cocktail
import com.example.shakemate.networking.ApiModule
import kotlinx.coroutines.launch

class CocktailViewModel(): ViewModel() {

    private var _cocktailsLiveData = MutableLiveData<List<Cocktail>>()
    val cocktailsLiveData: LiveData<List<Cocktail>> get() = _cocktailsLiveData

    fun fetchCocktails(cocktailName: String) {
        viewModelScope.launch {
            val response = getCocktails(cocktailName)
            if (response.cocktails==null) {
                print("response is null")
                _cocktailsLiveData.value = emptyList()
            }else
                _cocktailsLiveData.value = response.cocktails
            //print(_cocktailsLiveData.value)
            print("cocktails fetched")
        }
    }

    private suspend fun getCocktails(cocktailName: String) =
        ApiModule.retrofit.getCocktails(cocktailName)

    fun clearCocktails() {
        _cocktailsLiveData.value= emptyList()
    }


}