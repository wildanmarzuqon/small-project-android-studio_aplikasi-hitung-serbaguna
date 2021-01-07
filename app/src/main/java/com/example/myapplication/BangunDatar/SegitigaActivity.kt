package com.example.myapplication.BangunDatar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.myapplication.R

class SegitigaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segitiga)

        //deklarasi view
        val edtAlas : EditText = findViewById(R.id.edt_input_alas_segitiga)
        val edtTinggi : EditText = findViewById(R.id.edt_input_tinggi_segitiga)
        val btnBack : ImageButton = findViewById(R.id.btn_back_segitiga)
        val btnHitung : Button = findViewById(R.id.btn_hitung_segitiga)
        val tvwRumusLuas : TextView = findViewById(R.id.tvw_input_rumus_luas_segitiga)
        val tvwHasilLuas : TextView = findViewById(R.id.tvw_hasil_luas_segitiga)

        //inisialisasi button pindah activity
        btnBack.setOnClickListener {
            startActivity(Intent(this, BangunDatarActivity::class.java))
        }

        //inisialisasi button untuk error handling dan perhitungan
        btnHitung.setOnClickListener {
            if (edtAlas.text.toString().isEmpty()){
                edtAlas.setError("Alas Tidak Boleh Kosong")
            }else if(edtTinggi.text.toString().isEmpty()){
                edtTinggi.setError("Tinggi Tidak Boleh Kosong")
            }else{
                val alas = edtAlas.text.toString().toFloat()
                val tinggi = edtTinggi.text.toString().toFloat()
                val hasilSegitiga = LuasSegitiga(alas, tinggi)

                tvwRumusLuas.text = "  = \u00BD × a × t"
                tvwHasilLuas.text = "  = $hasilSegitiga"
            }
        }
    }

    //fungsi untuk perhitungan luas
    fun LuasSegitiga(a: Float, t: Float): Float{
        return 0.5f*a*t
    }
}