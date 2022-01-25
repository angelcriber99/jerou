package com.angel.zaml.interfaces

import android.telecom.Call
import com.angel.zaml.models.Pokemon
import retrofit.http.GET

//Llamadas para la API
interface Pokemon_Api {
    @GET("pokeapi.co/api/v2/")
    open fun findPokemon(user: String?): Call

}