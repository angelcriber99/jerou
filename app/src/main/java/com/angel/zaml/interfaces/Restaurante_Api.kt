package com.angel.zaml.interfaces

import android.telecom.Call
import com.angel.zaml.models.Restaurante
import com.angel.zaml.models.Result
import retrofit.http.GET
import retrofit.http.Headers
import javax.security.auth.callback.Callback

//Llamadas para la API
interface Restaurante_Api {
    //@GET("pokeapi.co/api/v2/")
    @GET("sede/servicio/monumento.json?fl=title,geometry&srsname=wsg84")
    @Headers("Accept: application/json")

    //open fun findPokemon(user: String?): Call
    fun findRestaurants(): retrofit.Callback<ArrayList<Result>>
    //añadir array

}