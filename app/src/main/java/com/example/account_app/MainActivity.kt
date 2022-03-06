package com.example.account_app

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val BtnLogin: Button = findViewById(R.id.Btn_Login)
        val BtnRegister: Button = findViewById(R.id.Btn_Register)

        var preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)


        BtnLogin.setOnClickListener {
            var kayitliKullaniciAdi = preferences.getString("Kullanici_Adi","")
            var kayitliParola = preferences.getString("Parola","")
            val txtKulAdi = findViewById<TextView>(R.id.editTextTextPersonName)
            val txtPass = findViewById<TextView>(R.id.editTextTextPersonPassword)

            if (kayitliKullaniciAdi == txtKulAdi.text.toString() && kayitliParola == txtPass.text.toString())
            {
                Toast.makeText(applicationContext,"Başarıyla giriş yapıldı", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(applicationContext,"$kayitliKullaniciAdi -- ${txtKulAdi.text.toString()}", Toast.LENGTH_LONG).show()

            }
        }

        BtnRegister.setOnClickListener {
            intent = Intent(applicationContext,MainRegister::class.java)
            startActivity(intent)
        }
    }
}