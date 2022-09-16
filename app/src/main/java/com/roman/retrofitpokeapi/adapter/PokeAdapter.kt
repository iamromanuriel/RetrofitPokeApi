package com.roman.retrofitpokeapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roman.retrofitpokeapi.R
import com.roman.retrofitpokeapi.ui.PokeResult

class PokeAdapter(val listpoke : List<PokeResult>): RecyclerView.Adapter<PokeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PokeViewHolder(layoutInflater.inflate(R.layout.card_poke, parent, false))
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        val pokemon = listpoke[position]
        holder.render(pokemon)
    }

    override fun getItemCount() = listpoke.size
}