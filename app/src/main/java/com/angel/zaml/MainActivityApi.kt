package com.angel.zaml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.angel.zaml.interfaces.Restaurante_Api
import com.angel.zaml.models.Result
import retrofit.GsonConverterFactory
import retrofit.Retrofit


class MainActivityApi : AppCompatActivity() {
    private lateinit var result : ArrayList<Result>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_api)
    }

    fun onLoad(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.zaragoza.es/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //Tipo PokemonAPI
        //Lo he cambiado a restaurantes
        val restaurantApi = retrofit.create(Restaurante_Api::class.java)
        //Tipo Call
        val llamada = restaurantApi.findRestaurants()


    }
}
