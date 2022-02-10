package com.angel.zaml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_splash.*


//import com.google.firebase.auth.FirebaseAuth

class Splash : AppCompatActivity() {
    private val tiempo : Long =2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val animacion : Animation
        val animacionDos : Animation

        animacion = AnimationUtils.loadAnimation( this,R.anim.animacion_top)
        animacionDos = AnimationUtils.loadAnimation( this,R.anim.animacion_botton)

        once.animation = animacion
        doce.animation = animacionDos

        val background = object : Thread(){
            override fun run() {
                super.run()
                try {
                    Thread.sleep((3*1000).toLong())
                    var user = FirebaseAuth.getInstance().currentUser
                        if (user != null){
                            val i = Intent(baseContext,MainActivity::class.java)
                            startActivity(i)
                      } else {
                            val i = Intent(baseContext, activity_login::class.java)
                            startActivity(i)
                        }
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()








        /*
        Handler().postDelayed({
            //Ver si esta inciada la sesion
         //   var user = FirebaseAuth.getInstance().currentUser
         //   if (user != null){
            //       startActivity(Intent(this, MainActivity::class.java))
          //  } else{
                startActivity(Intent(this, activity_login::class.java))
         //   }
        },tiempo)
        */

    }
}
