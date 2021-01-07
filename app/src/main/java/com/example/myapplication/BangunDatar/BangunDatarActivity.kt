package com.example.myapplication.BangunDatar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class BangunDatarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bangun_datar)

        //deklarasi view
        val btnBack : ImageButton = findViewById(R.id.btn_back_bangun_datar)
        val cvwLingkaran : CardView = findViewById(R.id.cvw_lingkaran)
        val cvwPersegi : CardView = findViewById(R.id.cvw_persegi)
        val cvwSegitiga : CardView = findViewById(R.id.cvw_segitiga)

        //inisialisasi button untuk berganti activity
        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        cvwLingkaran.setOnClickListener {
            startActivity(Intent(this, LingkaranActivity::class.java))
        }

        cvwPersegi.setOnClickListener {
            startActivity(Intent(this, PersegiActivity::class.java))
        }

        cvwSegitiga.setOnClickListener {
            startActivity(Intent(this, SegitigaActivity::class.java))
        }
    }
}