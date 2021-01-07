package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //deklarasi view
        val cvwBeratIdeal : CardView = findViewById(R.id.cvw_berat_ideal)
        val cvwBangunDatar : CardView = findViewById(R.id.cvw_bangun_datar)
        val cvwBangunRuang : CardView = findViewById(R.id.cvw_bangun_ruang)
        val cvwKonversiSuhu : CardView = findViewById(R.id.cvw_konversi_suhu)
        val cvwKonversiNilai : CardView = findViewById(R.id.cvw_konversi_nilai)

        //inisialisasi button untuk berpindah activity
        cvwBeratIdeal.setOnClickListener {
            startActivity(Intent(this, com.example.myapplication.BeratIdeal.BeratIdealActivity::class.java))
        }
        cvwBangunDatar.setOnClickListener {
            startActivity(Intent(this, com.example.myapplication.BangunDatar.BangunDatarActivity::class.java))
        }
        cvwBangunRuang.setOnClickListener {
            startActivity(Intent(this, com.example.myapplication.BangunRuang.BangunRuangActivity::class.java))
        }
        cvwKonversiSuhu.setOnClickListener {
            startActivity(Intent(this, com.example.myapplication.KonversiSuhu.KonversiSuhuActivity::class.java))
        }
        cvwKonversiNilai.setOnClickListener {
            startActivity(Intent(this, com.example.myapplication.KonversiNilai.KonversiNilaiActivity::class.java))
        }
    }
}