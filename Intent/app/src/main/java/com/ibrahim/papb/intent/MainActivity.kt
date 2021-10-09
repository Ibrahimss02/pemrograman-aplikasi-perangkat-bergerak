package com.ibrahim.papb.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnDaftar : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDaftar = findViewById(R.id.btnDaftar)

        btnDaftar.setOnClickListener {
            val intentToDaftar = Intent(this, DaftarActivity::class.java)
            startActivity(intentToDaftar)
        }

    }
}