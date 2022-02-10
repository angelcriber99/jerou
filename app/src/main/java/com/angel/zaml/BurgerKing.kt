package com.angel.zaml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class BurgerKing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_burger_king)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_tres_puntos, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val item_selected: Int = item.itemId

        if (item_selected == R.id.item1) {
            cambiarPantallaCuenta()
        }

        if (item_selected == R.id.item2) {
            Firebase.auth.signOut()
            val loginIntent = Intent(this, activity_login::class.java)
            startActivity(loginIntent)
        }
        return super.onOptionsItemSelected(item)
    }
    //Cambiar a la pantalla Cuenta
    fun cambiarPantallaCuenta(){
        val loginIntent = Intent(this, Cuenta::class.java)
        startActivity(loginIntent)
    }
}