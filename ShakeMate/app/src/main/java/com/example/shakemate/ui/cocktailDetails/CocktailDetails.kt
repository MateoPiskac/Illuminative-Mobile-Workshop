package com.example.shakemate.ui.cocktailDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.shakemate.R
import com.example.shakemate.data.Cocktail
import com.example.shakemate.databinding.FragmentCocktailDetailsBinding

class CocktailDetails(private val cocktail: Cocktail) : Fragment() {
    private lateinit var binding: FragmentCocktailDetailsBinding
    private lateinit var adapter: CocktailIngredientsAdapter

    private var ingedientList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initAdapter()
        binding = FragmentCocktailDetailsBinding.inflate(layoutInflater)
        binding.cocktailName.text = cocktail.name
        Glide.with(requireContext()).load(cocktail.image).centerCrop().into(binding.cocktailImage)
        binding.preparationInstructions.text = cocktail.instructions
        activity?.setActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root

    }

    private fun initAdapter() {
        adapter = CocktailIngredientsAdapter(ingedientList)
    }
}
