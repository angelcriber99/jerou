package com.angel.zaml

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.angel.zaml.databinding.ActivityCarritoBinding

class Carrito : AppCompatActivity() {


    private lateinit var binding: ActivityCarritoBinding
    private val MY_SHARED_PREF_NAME = "my_shared_pref"
    private val PRODUCTO1 = "producto 1"
    private val PRODUCTO2 = "producto 2"
    private val PRODUCTO3 = "producto 3"
    private val PRODUCTO4 = "producto 4"
    private val PRODUCTO5 = "producto 5"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showSavedData()

        binding.buttonconfirmar.setOnClickListener{
            saveData()
        }
    }

    private fun saveData() {

        val insertP1 = binding.elemento1.text.toString()
        val insertP2 = binding.elemento2.text.toString()
        val insertP3 = binding.elemento3.text.toString()
        val insertP4 = binding.elemento4.text.toString()
        val insertP5 = binding.elemento5.text.toString()

        val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME, Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putString(PRODUCTO1, insertP1)
        editor.putString(PRODUCTO2, insertP2)
        editor.putString(PRODUCTO3, insertP3)
        editor.putString(PRODUCTO4, insertP4)
        editor.putString(PRODUCTO5, insertP5)
        editor.apply()

        Toast.makeText(this, "Produtos confirmados", Toast.LENGTH_SHORT).show()

        binding.tvResult2.text = "Producto 1: $insertP1 \nProducto 2: $insertP2 \nProducto 3: $insertP3 \nProducto 4: $insertP4 \nProducto 5: $insertP5 "

    }

    // Mostrar datos guardados

    private fun showSavedData(){

        val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME, Context.MODE_PRIVATE)

        val P1 = sharedPref.getString(PRODUCTO1, "")
        val P2 = sharedPref.getString(PRODUCTO2, "")
        val P3 = sharedPref.getString(PRODUCTO3, "")
        val P4 = sharedPref.getString(PRODUCTO4, "")
        val P5 = sharedPref.getString(PRODUCTO5, "")

        binding.tvResult2.text = "Producto 1: $P1 \nProducto 2: $P2 \nProducto 3: $P3 \nProducto 4: $P4 \nProducto 5: $P5"

    }

}