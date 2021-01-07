package com.example.myapplication.BangunRuang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.myapplication.R

class BolaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bola)

        //deklarasi view
        val btnBack : ImageButton = findViewById(R.id.btn_back_bola)
        val btnHitung : Button = findViewById(R.id.btn_hitung_bola)
        val edtRadius : EditText = findViewById(R.id.edt_input_bola)
        val tvwRumusVolume : TextView = findViewById(R.id.tvw_input_rumus_volume_bola)
        val tvwRumusLp : TextView = findViewById(R.id.tvw_input_rumus_lp_bola)
        val tvwHasilVolume : TextView = findViewById(R.id.tvw_hasil_volume_bola)
        val tvwHasilLp : TextView = findViewById(R.id.tvw_hasil_lp_bola)

        //inisialisasi button click untuk kembali activity sebelumnya
        btnBack.setOnClickListener {
            startActivity(Intent(this, BangunRuangActivity::class.java))
        }

        //inisialisasi button click untuk menghitung dan error handling
        btnHitung.setOnClickListener {
            if (edtRadius.text.toString().isEmpty()){
                edtRadius.setError("Radius Tidak Boleh Kosong")
            }else{
                val r = edtRadius.text.toString().toFloat()
                val hasilVolume = RumusVolume(r)
                val hasilLp = RumusLp(r)

                tvwRumusLp.text = "   = 4 × 3.14 × $r²"
                tvwHasilVolume.text = "  = $hasilVolume"
                tvwRumusVolume.text = "  = 4/3 × 3.14 × $r³"
                tvwHasilLp.text = "   = $hasilLp"
            }
        }
    }

    //fungsi untuk perhitungan volume
    fun RumusVolume(r: Float): Float{
        return 1.3f*3.14f*(r*r*r)
    }

    //fungsi untuk perhitungan luas permukaan
    fun RumusLp(r: Float): Float{
        return 4*3.14f*(r*r)
    }
}