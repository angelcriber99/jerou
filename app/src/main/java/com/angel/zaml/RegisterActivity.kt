package com.angel.zaml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private val bd = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        privacyPolicyText.movementMethod = LinkMovementMethod.getInstance()



    }

    //Flecha arriba izq para ir hacia atrás
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun onClickRegisterButton(view: android.view.View) {

        if (EmailRegister.text.isNotEmpty() && ContraseñaRegister.text.isNotEmpty()){

            val nombreString = NombreRegister.text.toString()
            val apellidosString = ApellidosRegister.text.toString()
            val emailString = EmailRegister.text.toString()
            val passwordString = ContraseñaRegister.text.toString()
            val repeatPasswordString = RepetirContraseñaRegister.text.toString()

            if (checkBox.isChecked) {
                if(passwordString == repeatPasswordString) {
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(emailString, passwordString)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                bd.collection("users").document(emailString)
                                    .set(
                                        hashMapOf(
                                            "nombre" to nombreString,
                                            "apellidos" to apellidosString,
                                            "password" to passwordString
                                        )
                                    )

                                signUp()
                            } else {
                                showErrorRegister()
                            }
                        }
                } else {
                    showErrorPasswords()
                }
            } else {
                showErrorSwitch()
            }
        } else {
            showErrorRegister()
        }
    }

    private fun signUp() {
        val registerIntent = Intent(this, MainActivity::class.java)
        startActivity(registerIntent)

        val myToast = Toast.makeText(
            applicationContext,
            "¡Te has registrado con éxito!",
            Toast.LENGTH_SHORT
        )
        myToast.setGravity(Gravity.START, 200, 200)
        myToast.show()
    }

    private fun showErrorRegister() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Datos Erróneos")
        builder.setMessage("Por favor, introduce tus datos correctamente.")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showErrorSwitch() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Hey!")
        builder.setMessage("Por favor, lee y acepta nuestros términos para continuar.")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showErrorPasswords() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Hey!")
        builder.setMessage("¡Las contraseñas no coinciden!")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}