package com.example.shakemate.ui.searchCocktails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shakemate.R
import com.example.shakemate.data.COCKTAIL
import com.example.shakemate.data.Cocktail
import com.example.shakemate.databinding.FragmentSearchBinding
import com.example.shakemate.ui.cocktailDetails.CocktailDetails

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: CocktailAdapter
    private val viewModel = CocktailViewModel()
    val list = mutableListOf<Cocktail>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.fetchCocktails("")
        binding = FragmentSearchBinding.inflate(layoutInflater)
        initAdapter()
        adapter.submitList(emptyList())
        viewModel.cocktailsLiveData.observe(viewLifecycleOwner) { cocktails ->
            adapter.submitList(cocktails)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.fetchCocktails(query ?: "")
                adapter.notifyDataSetChanged()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    if (newText.length > 3) {
                        viewModel.fetchCocktails(newText)
                        adapter.notifyDataSetChanged()
                    }
                }
                return true
            }
        })
        binding.cocktailList.adapter = adapter
        viewModel.cocktailsLiveData.observe(viewLifecycleOwner) { cocktails ->
            Log.e("debag", cocktails[0].toString())
            adapter.submitList(cocktails)
        }
        return binding.root
    }

    private fun initAdapter() {
        adapter = CocktailAdapter(emptyList()) { cocktail ->
            val bundle = bundleOf(COCKTAIL to cocktail)
            findNavController().navigate(R.id.action_searchFragment_to_cocktailDetails, bundle)
        }
    }

}