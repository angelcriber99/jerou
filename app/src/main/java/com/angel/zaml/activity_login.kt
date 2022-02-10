package com.angel.zaml

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_login.*

class activity_login : AppCompatActivity() {


    //REGISTRARSE CON GOOGLE  {
    private val GOOGLE_SIGN_IN = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Firebase tutorial")
        analytics.logEvent("InitScreen", bundle)

        checkSession()

        val googleConf = GoogleSignInOptions.
        Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
        requestIdToken(getString(R.string.default_web_client_id2))
            .
            requestEmail().
            build()
        val gClient = GoogleSignIn.getClient(this,
            googleConf)

        val registerButton : ImageView = findViewById(R.id.googleBtn)
        registerButton.setOnClickListener{
            gClient.signOut()
            val intent = gClient.signInIntent
            startActivityForResult(intent, 100)
        }

        val phoneRegisterBtn : ImageView = findViewById(R.id.phoneRegisterBtn)
        phoneRegisterBtn.setOnClickListener{
            CambiarPantallaTelefono()
        }

    }

    override fun onActivityResult(requestCode: Int,
                                  resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_SIGN_IN) {
            val task =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.
                getResult(ApiException::class.java)!!
                if(account != null){
                    val credential = GoogleAuthProvider.
                    getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().
                    signInWithCredential(credential)
                        .addOnCompleteListener{
                            if(it.isSuccessful){
                                signIn()
                            }
                            else{
                                showErrorGoogle()
                            }
                        }
                }
            } catch (e: ApiException) {
                showErrorGoogle()
            }
        }
    }

    private fun signIn() {

        val registerIntent = Intent(this, MainActivity::class.java)
        startActivity(registerIntent)

        val myToast = Toast.makeText(
            applicationContext, "Welcome to Jerou! :) " + Email.toString(),
            Toast.LENGTH_SHORT
        )
        myToast.setGravity(Gravity.START, 200, 200)
        myToast.show()
    }

    private fun checkSession(){
        val preferences =
            getSharedPreferences(getString(R.string.preferences),
                Context.MODE_PRIVATE)
        val email = preferences.getString("email", null)
        if(email != null){
            signIn()
        }
    }
    fun forgotPassword(view: View) {
        startActivity(
            Intent(
                this,
                ForgotPasswordActivity::class.java
            )
        )
    }

    private fun showErrorGoogle() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Failed Login In with Google")
        builder.setMessage("Please, try again")
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    // } HASTA AQUÍ REGISTRARSE CON GOOGLE

    //Funcion que hace login login
    fun onClickLogin(view: android.view.View) {
        //Esto de va a realizar cuando pulse el boton Next
        //Intent es una clase que recibe dos parametros, donde estamos y a donde vamos
        var email= R.id.Email
        var password=R.id.Password

        if (email != null && password != null) {
            //Comprobamos que los campos no son vacios
            if (email.toString() != "" && password.toString() != "") {
                try {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(
                        email.toString(),
                        password.toString()
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
                val email = Email.toString()
                val password = Password.toString()
                if (email == "" || email ==null) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Error")
                    builder.setMessage("Email is empty. You must enter an email")
                    builder.setPositiveButton("OK", null)
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                }
                if (password == "" || password ==null || password.length<6) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Error")
                    builder.setMessage("Password is empty or it is invalid. You must enter a password with more than 6 characters")
                    builder.setPositiveButton("OK", null)
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                }
            }
        }
    }

    private fun showLoginActivity(){
        val myToast = Toast.makeText(applicationContext,"Welcome "+Email.toString(), Toast.LENGTH_SHORT)
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
    fun CambiarPantallaRegistro(view: View){
        val registerIntent = Intent(this, RegisterActivity::class.java)
        startActivity(registerIntent)

    }

    //Registro telefono
    fun CambiarPantallaTelefono() {
        var loginIntent = Intent(this, PhoneRegister::class.java)
        //Empezamos el intento
        startActivity(loginIntent)
    }
}