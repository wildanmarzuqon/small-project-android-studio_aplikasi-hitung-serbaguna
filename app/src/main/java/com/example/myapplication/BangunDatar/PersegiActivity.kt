package com.example.myapplication.BangunDatar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.myapplication.R

class PersegiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persegi)

        //deklarasi view
        val edtInput : EditText = findViewById(R.id.edt_input_persegi)
        val btnHitung : Button = findViewById(R.id.btn_hitung_persegi)
        val btnBack : ImageButton = findViewById(R.id.btn_back_persegi)
        val tvwRumusLuas : TextView = findViewById(R.id.tvw_input_rumus_luas_persegi)
        val tvwRumusKeliling : TextView = findViewById(R.id.tvw_input_rumus_keliling_persegi)
        val tvwHasilLuas : TextView = findViewById(R.id.tvw_hasil_luas_persegi)
        val tvwHasilKeliling : TextView = findViewById(R.id.tvw_hasil_keliling_persegi)

        //inisialisasi button untuk berpindah activity
        btnBack.setOnClickListener {
            startActivity(Intent(this, BangunDatarActivity::class.java))
        }

        //inisialisasi button error handling dan perhitungan
        btnHitung.setOnClickListener {
            if (edtInput.text.toString().isEmpty()){
                edtInput.setError("Sisi Tidak Boleh Kosong")
            }else{
                val sisi = edtInput.text.toString().toFloat()
                val hasilLuas = HitungLuas(sisi)
                val hasilKeliling = HitungKeliling(sisi)

                tvwRumusKeliling.text = "  = $sisi²"
                tvwHasilKeliling.text = "  = $hasilKeliling"
                tvwRumusLuas.text = "  = 4 × $sisi"
                tvwHasilLuas.text = "  = $hasilLuas"
            }
        }
    }

    //fungsi untuk perhitungan luas
    fun HitungLuas(s : Float): Float{
        return s*s
    }

    //fungsi untuk perhitungan keliling
    fun HitungKeliling(s : Float): Float{
        return 4*s
    }
}