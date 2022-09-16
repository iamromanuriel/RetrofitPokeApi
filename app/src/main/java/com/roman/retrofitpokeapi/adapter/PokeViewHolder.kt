package com.roman.retrofitpokeapi.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.roman.retrofitpokeapi.databinding.CardPokeBinding
import com.roman.retrofitpokeapi.ui.PokeResult

class PokeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = CardPokeBinding.bind(view)

    fun render(poke : PokeResult){
        binding.namepoke.text = poke.name
    }
}