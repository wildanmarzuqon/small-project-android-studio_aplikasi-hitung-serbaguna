package com.example.myapplication.BangunDatar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class LingkaranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lingkaran)

        //deklarasi view
        val edtInputAngka : EditText = findViewById(R.id.edt_input_lingkaran)
        val btnHitung : Button = findViewById(R.id.btn_hitung_lingkaran)
        val btnBack : ImageButton = findViewById(R.id.btn_back_lingkaran)
        val tvwRumusLuasLingkaran : TextView = findViewById(R.id.tvw_input_rumus_luas_lingkaran)
        val tvwRumusKelilingLingkaran : TextView = findViewById(R.id.tvw_input_rumus_keliling_lingkaran)
        val tvwHasilLuas : TextView = findViewById(R.id.tvw_hasil_luas_lingkaran)
        val tvwHasilKeliling : TextView = findViewById(R.id.tvw_hasil_keliling_lingkaran)

        //inisialisasi button untuk berpindah activity
        btnBack.setOnClickListener {
            startActivity(Intent(this, BangunDatarActivity::class.java))
        }

        //inisialisasi button untuk error handling dan perhitungan
        btnHitung.setOnClickListener {
            if (edtInputAngka.text.toString().isEmpty()){
                edtInputAngka.setError("Radius Tidak Boleh Kosong")
            } else {
                val r = edtInputAngka.text.toString().toFloat()
                val hasilLuas = RumusLuas(r)
                val hasilKeliling = RumusKeliling(r)
                val phi = 3.14f

                tvwRumusLuasLingkaran.text = "  = $phi × $r²"
                tvwHasilLuas.text = "  = $hasilLuas"
                tvwRumusKelilingLingkaran.text = "  = 2 × $phi × $r"
                tvwHasilKeliling.text = "  = $hasilKeliling"
            }
        }
    }

    //fungsi untuk perhitungan luas
    fun RumusLuas(r : Float): Float{
        return 3.14f*(r*r)
    }

    //fungsi untuk perhitungan keliling
    fun RumusKeliling(r : Float): Float{
        return 2*3.14f*r
    }
}