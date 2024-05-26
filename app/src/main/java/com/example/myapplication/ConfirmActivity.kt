package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ConfirmActivity : AppCompatActivity() {

    private lateinit var amplifyCognito: AmplifyCognito

    private lateinit var etCode: EditText
    private lateinit var btnVerify: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        amplifyCognito = AmplifyCognito(applicationContext)
        val intent = getIntent()
        val username = intent.getStringExtra("username").toString()

        etCode = findViewById(R.id.etCode)
        btnVerify = findViewById(R.id.btnVerify)
        btnVerify.setOnClickListener {
            val code = etCode.text.toString()
            amplifyCognito.confirm(username, code)
        }
    }
}