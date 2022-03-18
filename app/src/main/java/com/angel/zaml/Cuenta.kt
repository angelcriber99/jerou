package com.angel.zaml

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.angel.zaml.databinding.ActivityCuentaBinding
import com.google.firebase.auth.FirebaseAuth

class Cuenta : AppCompatActivity() {


    private lateinit var binding: ActivityCuentaBinding
    private val MY_SHARED_PREF_NAME = "my_shared_pref"
    private val DNI = "dni"
    private val HOME = "home"
    private val EMAIL = "email"
    private val CP = "codigo postal"
    private val NUMTEL = "numero telefono"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showSavedData()

        binding.btnSave.setOnClickListener {
            saveData()
        }

    }

    private fun saveData() {

        val insertDNI = binding.dnicuenta.text.toString()
        val insertHome = binding.direccioncuenta.text.toString()
        val insertEMAIL = binding.emailcuenta.text.toString()
        val insertCP = binding.cpcuenta.text.toString()
        val insertNUMTEL = binding.telefonocuenta.text.toString()

        val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME,
            Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putString(DNI, insertDNI)
        editor.putString(HOME, insertHome)
        editor.putString(EMAIL, insertEMAIL)
        editor.putString(CP, insertCP)
        editor.putString(NUMTEL, insertNUMTEL)
        editor.apply()

        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()

        binding.tvResult.text = "Nombre: $insertDNI \nDirección: $insertHome \nEmail: $insertEMAIL \nCódigo Postal: $insertCP \nNúmero de teléfono: $insertNUMTEL"

    }

    // Mostrar los datos guardados

    private fun showSavedData(){

        val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME, Context.MODE_PRIVATE)

        val dni = sharedPref.getString(DNI, "")
        val home = sharedPref.getString(HOME, "")
        val email = sharedPref.getString(EMAIL, "")
        val cp = sharedPref.getString(CP, "")
        val numtel = sharedPref.getString(NUMTEL, "")

        binding.tvResult.text = "Nombre: $dni \nDirección: $home \nEmail: $email \nCódigo Postal: $cp \nNúmero de teléfono: $numtel"


    }

    fun onClickLogOut(view: android.view.View) {
        FirebaseAuth.getInstance().signOut()

        val onClickLogOut = Intent(this, activity_login::class.java)
        startActivity(onClickLogOut)

        Toast.makeText(this@Cuenta,"Has cerrado sesión", Toast.LENGTH_SHORT).show()
    }
}