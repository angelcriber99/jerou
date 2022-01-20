package com.angel.zaml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class activity_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    //Funcion que hace login login
    fun onClickLogin(view: android.view.View) {
        //Esto de va a realizar cuando pulse el boton Next
        //Intent es una clase que recibe dos parametros, donde estamos y a donde vamos


        if (Email.text != null && Password.text != null) {
            //Comprobamos que los campos no son vacios
            if (Email.text.toString() != "" && Password.text.toString() != "") {
                try {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(
                        Email.text.toString(),
                        Password.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showLoginActivity()
                            val loginIntent = Intent(this, MainActivity::class.java)
                            //Empezamos el intento
                            startActivity(loginIntent)
                        } else {
                            showError()
                        }

                    }
                } catch (ex: Exception) {
                    showError()
                }
            }else{
                val email = Email.text.toString()
                val password = Password.text.toString()
                if (email == "" || email ==null) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Error")
                    builder.setMessage("Email is empty. You must entering an email")
                    builder.setPositiveButton("OK", null)
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                }
                if (password == "" || password ==null || password.length<6) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Error")
                    builder.setMessage("Password is empty or it is invalid. You must entering a password with more than 6 characters")
                    builder.setPositiveButton("OK", null)
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                }
            }
        }
    }

    private fun showLoginActivity(){
        val myToast = Toast.makeText(applicationContext,"Welcome "+Email.text.toString(), Toast.LENGTH_SHORT)
        myToast.setGravity(Gravity.LEFT,200,200)
        myToast.show()
        val loginIntent = Intent(this, MainActivity::class.java)
        //Empezamos el intento
        startActivity(loginIntent)
    }

    private fun showError(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("An error with Firebase has occured")
        builder.setPositiveButton("OK", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    //Cambiar pantalla Registro
    fun cambiarPantallaRegistro(view: android.view.View){
        val registerIntent = Intent(this, RegisterActivity::class.java)
        startActivity(registerIntent)

    }

    //Registro telefono
    fun cambiarPantallaTelefono(view: View){
        var loginIntent = Intent(this, PhoneRegister::class.java)
        //Empezamos el intento
        startActivity(loginIntent)
    }
}