package com.roman.retrofitpokeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.roman.retrofitpokeapi.adapter.PokeAdapter
import com.roman.retrofitpokeapi.databinding.ActivityMainBinding
import com.roman.retrofitpokeapi.viewmodel.Pokeviewmodel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewmodel: Pokeviewmodel
    private lateinit var adapter: PokeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel = ViewModelProvider(this)
            .get(Pokeviewmodel::class.java)

        viewmodel.getPokemonList()

        var recycler = binding.recycler

        viewmodel.pokemonList.observe(this, Observer { listpoke ->
            adapter = PokeAdapter(listpoke)
            recycler.hasFixedSize()
            recycler.layoutManager = LinearLayoutManager(this)
            recycler.adapter = adapter
        })
    }
}