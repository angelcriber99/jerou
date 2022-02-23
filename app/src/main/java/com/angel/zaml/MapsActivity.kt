package com.angel.zaml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.angel.zaml.databinding.ActivityMapsBinding
import com.angel.zaml.interfaces.Restaurante_Api
import com.angel.zaml.models.Result
import com.google.gson.Gson
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit
import kotlin.collections.ArrayList

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var restaurants: ArrayList<Result>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        onLoad()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        //Marker of Zaragoza



        // Add a marker in Sydney and move the camera
        val sydney = LatLng(40.41, -3.7)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Madrid"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))


    }
    //Restaurantes
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

        llamada.enqueue(
            object : Callback<Result>{
                override fun onResponse(response: Response<Result>?, retrofit: Retrofit?) {
                    val restaurantes : Result? = response?.body()

                    val arrayRestaurantes = restaurantes?.getResult()

                    if(arrayRestaurantes!=null)
                        for(num in 0 until (arrayRestaurantes.size)){


                            Log.i("PRUEBA : ", Gson().toJson(arrayRestaurantes.get(num).getTitle()))
                            Log.i("---- : ", Gson().toJson(
                                arrayRestaurantes.get(num).getGeometry().getCoordinates()!!.get(0)))
                            Log.i("---- : ", Gson().toJson(arrayRestaurantes.get(num).getGeometry().getCoordinates()!!.get(1)))
                        }
                }

                override fun onFailure(t: Throwable?) {

                }

            }
        )
    }
}
