package com.angel.zaml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //esta funcion crea menu de los tres puntos

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_tres_puntos, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val item_selected: Int = item.itemId

        if (item_selected == R.id.item1) {
            /*Firebase.auth.signOut()
            cambiarPantallaLogin()*/
            // val loginIntent = Intent(this, Cuentas::class.java)
            // startActivity(loginIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}