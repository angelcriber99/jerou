package com.angel.zaml

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.angel.zaml.databinding.ActivityPhoneRegisterBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class PhoneRegister : AppCompatActivity() {
    //view binding
    private lateinit var binding: ActivityPhoneRegisterBinding
    //if code sending failed, will used to resend
    private var forceResendingToken:PhoneAuthProvider.ForceResendingToken? = null

    private var mCallBacks:PhoneAuthProvider.OnVerificationStateChangedCallbacks?=null
    private var mVerificationId: String? =null
    private lateinit var firebaseAuth:FirebaseAuth

    private val TAG ="MAIN_TAG"

    //process dialog
    private lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPhoneRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.phoneLl.visibility = View.VISIBLE
        binding.codeLl.visibility = View.GONE

        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setCanceledOnTouchOutside(false)

        mCallBacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                //This callback will invoked in two situations:
                //1 - Instant verification. In some cases the number can be instantly
                //    verified without needing send or enter a verification code
                //2 - Auto-retrieval. On some devices Google Play services can automatically
                //    detect the incoming verification SMS and perform verification without
                //    user action.
                signInWithPhoneAuthCredential(phoneAuthCredential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                //This callback is invokes in an invalid request for verification is made,
                //for instance if the phone number formar is not valid.

                progressDialog.dismiss()
                Toast.makeText(this@PhoneRegister,"${e.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                //The SMS verification code has been sent to the provided phone number, we
                //now need to ask the user to enter the code and then constuct a credential
                //by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent: $verificationId")
                mVerificationId=verificationId
                forceResendingToken = token
                progressDialog.dismiss()

                //hide phone layout, show code layout
                binding.phoneLl.visibility=View.GONE
                binding.codeLl.visibility=View.VISIBLE
                Toast.makeText(this@PhoneRegister,"Verification code sent...", Toast.LENGTH_SHORT).show()
                binding.codeSentDescriptionTv.text= "Please type the verification code we sent to ${binding.phoneEt.text.toString().trim()}"

            }
        }
        //phoneContinueBtn click: input phone number, validate, start phone authentication/login
        binding.phoneContinueBtn.setOnClickListener {
            //Input phone number
            val phone = binding.phoneEt.text.toString().trim()
            //validate phone number
            if (TextUtils.isEmpty(phone)){
                Toast.makeText(this@PhoneRegister,"Please enter phone number", Toast.LENGTH_SHORT).show()
            } else{
                startPhoneNumberVerification(phone)
            }
        }

        //resendCodeTv click: (if code didn't receive) resend verification code / OTP
        binding.resendCodeTv.setOnClickListener{
            //Input phone number
            val phone = binding.phoneEt.text.toString().trim()
            //validate phone number
            if (TextUtils.isEmpty(phone)){
                Toast.makeText(this@PhoneRegister,"Please enter phone number", Toast.LENGTH_SHORT).show()
            } else{
                resendVerificationCode(phone,forceResendingToken)
            }
        }

        //codeSubmitBtn click: input verification code, validate, verify phone number with verification code
        binding.codeSubmitBtn.setOnClickListener{
            //input verification code
            val code= binding.CodeEt.text.toString().trim()
            if (TextUtils.isEmpty(code)){
                Toast.makeText(this@PhoneRegister,"Please enter verification code", Toast.LENGTH_SHORT).show()
            }else{
                verifyPhoneWithCode(mVerificationId!!, code)
            }
        }
    }
    private fun startPhoneNumberVerification(phone:String){
        progressDialog.setMessage("Verifying Phone Number...")
        progressDialog.show()
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phone)
            .setTimeout(60L,TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(mCallBacks!!)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun resendVerificationCode(phone: String, token: PhoneAuthProvider.ForceResendingToken?){
        progressDialog.setMessage("Resending Code...")
        progressDialog.show()

        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phone)
            .setTimeout(60L,TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(mCallBacks!!)
            .setForceResendingToken(token!!)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyPhoneWithCode(verificationId: String, code:String){
        progressDialog.setMessage("Verifying code...")
        progressDialog.show()

        val credential = PhoneAuthProvider.getCredential(verificationId, code)
        signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        progressDialog.setMessage("Logging In")

        firebaseAuth.signInWithCredential(credential)
            .addOnSuccessListener {
                //login success
                progressDialog.dismiss()
                val phone = firebaseAuth.currentUser!!.phoneNumber
                Toast.makeText(this,"Logged IN as $phone", Toast.LENGTH_SHORT).show()

                //Start profile activity
                var volverIntent = Intent(this, MainActivity::class.java)

                //Empezamos el intento
                startActivity(volverIntent)

            }
            .addOnFailureListener { e->
                //login failed
                progressDialog.dismiss()
                Toast.makeText(this,"${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

}
