package com.angel.zaml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
//import com.google.firebase.auth.FirebaseAuth

class Splash : AppCompatActivity() {
    private val tiempo : Long =2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        Handler().postDelayed({
            //Ver si esta inciada la sesion
            /*var user = FirebaseAuth.getInstance().currentUser
            if (user!= null){
                startActivity(Intent(this, App_Registered::class.java))
            } else{
                startActivity(Intent(this, MainActivity::class.java))
            }*/
            startActivity(Intent(this, activity_login::class.java))
            finish()
        },tiempo)


    }
}