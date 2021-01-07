package com.example.myapplication.BangunRuang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class BangunRuangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bangun_ruang)

        //deklarasi view
        val cvwTabung : CardView = findViewById(R.id.cvw_tabung)
        val cvwBalok : CardView = findViewById(R.id.cvw_balok)
        val cvwBola : CardView = findViewById(R.id.cvw_bola)
        val btnBack : ImageButton = findViewById(R.id.btn_back_bangun_ruang)

        //inisialisai button untuk masuk ke activity selanjutnya
        cvwTabung.setOnClickListener {
            startActivity(Intent(this, TabungActivity::class.java))
        }

        cvwBalok.setOnClickListener {
            startActivity(Intent(this, BalokActivity::class.java))
        }

        cvwBola.setOnClickListener {
            startActivity(Intent(this, BolaActivity::class.java))
        }

        //inisialisasi button untuk kembali ke activity sebelumnya
        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}