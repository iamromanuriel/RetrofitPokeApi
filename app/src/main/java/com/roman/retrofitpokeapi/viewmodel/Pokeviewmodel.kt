package com.roman.retrofitpokeapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roman.retrofitpokeapi.data.Pokeservice
import com.roman.retrofitpokeapi.ui.PokeApiResponse
import com.roman.retrofitpokeapi.ui.PokeResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Pokeviewmodel: ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: Pokeservice = retrofit.create(Pokeservice::class.java)

    val pokemonList = MutableLiveData<List<PokeResult>>()

    fun getPokemonList(){
        val call = service.getPokemonList(100,0)

        call.enqueue(object : Callback<PokeApiResponse>{
            override fun onResponse(call: Call<PokeApiResponse>,response: Response<PokeApiResponse>) {
                response.body()?.results?.let { list ->
                    pokemonList.postValue(list)
                }

            }

            override fun onFailure(call: Call<PokeApiResponse>, t: Throwable) {
                call.cancel()
            }

        })
    }


}