package com.example.shakemate.ui.searchCocktails

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shakemate.data.Cocktail
import com.example.shakemate.databinding.ItemCocktailListBinding

class CocktailAdapter(private var cocktails: List<Cocktail>, private val onItemClickCallback: (Cocktail) -> Unit) :
    RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {
    inner class CocktailViewHolder(private val binding: ItemCocktailListBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cocktail: Cocktail) {
            binding.cardView.setOnClickListener {
                onItemClickCallback.invoke(cocktail)
            }
            binding.cocktailName.text = cocktail.name
            Glide.with(context).load(cocktail.image).centerCrop().into(binding.cocktailImage)
            binding.cocktailInstructions.text = cocktail.instructions
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailAdapter.CocktailViewHolder {
        val binding = ItemCocktailListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CocktailViewHolder(binding, parent.context)

    }

    override fun onBindViewHolder(holder: CocktailAdapter.CocktailViewHolder, position: Int) {
        holder.bind(cocktails[position])
    }

    override fun getItemCount(): Int {
        return cocktails.size
    }

    fun submitList (newList: List<Cocktail>) {
        cocktails = newList
        Log.e("SUBMIT ITEM",cocktails.toString())
    }
}