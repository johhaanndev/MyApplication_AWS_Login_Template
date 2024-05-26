package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var amplifyCognito: AmplifyCognito

    private lateinit var tvUsername: TextView
    private lateinit var btnLogOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        amplifyCognito = AmplifyCognito(applicationContext)

        tvUsername = findViewById(R.id.tvUsername)
        btnLogOut = findViewById(R.id.btnSignOut)

        val intent = intent
        val username = intent.getStringExtra("username")

        tvUsername.text = "Welcome $username!"

        btnLogOut.setOnClickListener{
            amplifyCognito.SignOut()
        }
    }
}