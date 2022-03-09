package com.angel.zaml

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.appcompat.app.AppCompatActivity
import com.angel.zaml.databinding.ActivityMapsBinding
import com.angel.zaml.interfaces.Restaurante_Api
import com.angel.zaml.models.RestaurantePersonalizado
import com.angel.zaml.models.Result
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit.GsonConverterFactory
import retrofit.Retrofit


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var restaurants: ArrayList<RestaurantePersonalizado>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        restaurants = ArrayList()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        //onLoad()
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


        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.zaragoza.es/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //Tipo PokemonAPI
        //Lo he cambiado a restaurantes
        val restaurantApi = retrofit.create(Restaurante_Api::class.java)
        //Tipo Call
        val llamada = restaurantApi.findRestaurants()

        val response = llamada.execute()

        val restaurantes: Result? = response?.body()

        val arrayRestaurantes = restaurantes?.getResult()


        if (arrayRestaurantes != null)
            for (num in 0 until (arrayRestaurantes.size)) {

                val aux = arrayRestaurantes.get(num)

                val rPersonalizado = RestaurantePersonalizado()

                rPersonalizado.setTitle(aux.getTitle())
                rPersonalizado.setLat(aux.getGeometry().getCoordinates()!![0])
                rPersonalizado.setLng(aux.getGeometry().getCoordinates()!![1])


                /*aux.getGeometry().getCoordinates()
                    ?.let { rPersonalizado.setLng(it.get(0)) }
                aux.getGeometry().getCoordinates()
                    ?.let { rPersonalizado.setLat(it.get(1)) }*/
                restaurants.add(rPersonalizado)

                /*llamada.enqueue(
            object : Callback<Result>{
                override fun onResponse(response: Response<Result>?, retrofit: Retrofit?) {
                    val restaurantes : Result? = response?.body()

                    val arrayRestaurantes = restaurantes?.getResult()


                    if(arrayRestaurantes!=null)
                        for(num in 0 until (arrayRestaurantes.size)){

                            val aux = arrayRestaurantes.get(num)

                            val rPersonalizado = RestaurantePersonalizado()

                            rPersonalizado.setTitle(aux.getTitle())
                            rPersonalizado.setLat(aux.getGeometry().getCoordinates()!![0])
                            rPersonalizado.setLng(aux.getGeometry().getCoordinates()!![1])


                            /*aux.getGeometry().getCoordinates()
                                ?.let { rPersonalizado.setLng(it.get(0)) }
                            aux.getGeometry().getCoordinates()
                                ?.let { rPersonalizado.setLat(it.get(1)) }*/
                            restaurants.add(rPersonalizado)

                            /*val restaurante = RestaurantePersonalizado()
                            restaurante.setTitle(Gson().toJson(arrayRestaurantes.get(num).getTitle()))
                            restaurante.setLat(Gson().toJson(
                                arrayRestaurantes.get(num).getGeometry().getCoordinates()!!.get(0)).toDouble())
                            restaurante.setLng(Gson().toJson(arrayRestaurantes.get(num).getGeometry().getCoordinates()!!.get(1)).toDouble())
                            restaurants.add(restaurante)
*/
                            /*restaurants.add(Gson().toJson(arrayRestaurantes.get(num).getTitle()),Gson().toJson(
                                arrayRestaurantes.get(num).getGeometry().getCoordinates()!!.get(0)), Gson().toJson(arrayRestaurantes.get(num).getGeometry().getCoordinates()!!.get(1)))*/

                            /*Log.i("PRUEBA : ", Gson().toJson(arrayRestaurantes.get(num).getTitle()))
                            Log.i("---- : ", Gson().toJson(
                                arrayRestaurantes.get(num).getGeometry().getCoordinates()!!.get(0)))
                            Log.i("---- : ", Gson().toJson(arrayRestaurantes.get(num).getGeometry().getCoordinates()!!.get(1)))*/
                        }
                }

                override fun onFailure(t: Throwable?) {

                }
*/
            }

        for (num in 0 until (restaurants.size)) {
            val title = restaurants.get(num).getTitle();
            val lat : Double =  restaurants.get(num).getLat()!!.toDouble();
            val lng : Double = restaurants.get(num).getLng()!!.toDouble();


            val localizacion = LatLng(lat, lng)
            googleMap.addMarker(
                MarkerOptions()
                    .position(localizacion)
                    .title(title)
            )
            //googleMap.moveCamera(CameraUpdateFactory.newLatLng(localizacion))


        }


        // Add a marker in Sydney and move the camera
        /*val sydney = LatLng(40.41, -3.7)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Madrid"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/


    }
}

