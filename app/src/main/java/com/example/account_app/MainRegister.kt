package com.example.account_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_register)

        val btnConfirm = findViewById<Button>(R.id.btn_Confirm)
        val btnMenu = findViewById<Button>(R.id.btn_Menu)

        btnMenu.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }

        btnConfirm.setOnClickListener {
            val txtKuallaniciAdi = findViewById<TextView>(R.id.editTextTextKayitKullaniciAdi)
            val txtSifre = findViewById<TextView>(R.id.editTextTextKayitSifre)
            val sharedPreferences = this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("Kullanici_Adi",txtKuallaniciAdi.text.toString()).apply()
            editor.putString("Parola",txtSifre.text.toString()).apply()
            Toast.makeText(applicationContext,"Bilgiler başarıyla kayıt edildi",Toast.LENGTH_LONG).show()
            txtKuallaniciAdi.text = ""
            txtSifre.text = ""
        }
    }
}