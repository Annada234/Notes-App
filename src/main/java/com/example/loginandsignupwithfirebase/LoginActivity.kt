package com.example.loginandsignupwithfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginandsignupwithfirebase.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))

            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()



   binding.logInButton.setOnClickListener {
       val Email: String = binding.Email.text.toString()
       val password: String = binding.Password.text.toString()
       if(Email.isEmpty() || password.isEmpty()) {
           Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show()

       }else{
           auth.signInWithEmailAndPassword(Email, password).addOnCompleteListener(this){
               task->
               if(task.isSuccessful) {
                   Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                   startActivity(Intent(this, MainActivity::class.java))
                   finish()

               }else{
                   Toast.makeText(this, "Login Failed : ${task.exception?.message}", Toast.LENGTH_SHORT).show()
               }
           }

       }
   }

        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
    }
}
