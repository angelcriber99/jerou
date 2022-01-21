package com.angel.zaml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Cuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuenta)
    }

    fun onClickLogOut(view: android.view.View) {
        FirebaseAuth.getInstance().signOut()

        val onClickLogOut = Intent(this, activity_login::class.java)
        startActivity(onClickLogOut)

        Toast.makeText(this@Cuenta,"Has cerrado sesión", Toast.LENGTH_SHORT).show()
    }
}