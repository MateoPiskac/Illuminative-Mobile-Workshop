package com.example.shakemate.ui.cocktailDetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shakemate.databinding.ItemIngredientListBinding

class CocktailIngredientsAdapter(private val ingredientsList: List<String?>) :
    RecyclerView.Adapter<CocktailIngredientsAdapter.CocktailIngredientsViewHolder>() {

    inner class CocktailIngredientsViewHolder(private val binding: ItemIngredientListBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ingredient: String) {
            binding.ingredientName.text = ingredient
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailIngredientsViewHolder {
        val binding = ItemIngredientListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CocktailIngredientsViewHolder(binding, parent.context)
    }

    override fun getItemCount(): Int {
        return ingredientsList.size
    }

    override fun onBindViewHolder(holder: CocktailIngredientsViewHolder, position: Int) {
        holder.bind(ingredientsList[position] ?: "")
    }
}
