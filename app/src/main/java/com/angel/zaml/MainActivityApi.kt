package com.angel.zaml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.angel.zaml.interfaces.Pokemon_Api
import retrofit.GsonConverterFactory
import retrofit.Retrofit


class MainActivityApi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_api)
    }

    fun onLoad(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //Tipo PokemonAPI
        val pokeApi = retrofit.create(Pokemon_Api::class.java)
        //Tipo Call
        val llamada = pokeApi.findPokemon("151")
    }
}