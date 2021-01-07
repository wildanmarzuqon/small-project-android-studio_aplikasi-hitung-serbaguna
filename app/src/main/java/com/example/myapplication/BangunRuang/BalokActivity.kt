package com.example.myapplication.BangunRuang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.myapplication.R

class BalokActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balok)

        //deklarasi view
        val edtPanjang : EditText = findViewById(R.id.edt_input_panjang_balok)
        val edtLebar : EditText = findViewById(R.id.edt_input_lebar_balok)
        val edtTinggi : EditText = findViewById(R.id.edt_input_tinggi_balok)
        val btnHitung : Button = findViewById(R.id.btn_hitung_balok)
        val btnBack : ImageButton = findViewById(R.id.btn_back_balok)
        val tvwRumusVolumeBalok : TextView = findViewById(R.id.tvw_input_rumus_volume_balok)
        val tvwHasilVolumeBalok : TextView = findViewById(R.id.tvw_hasil_volume_balok)
        val tvwRumusLpBalok : TextView = findViewById(R.id.tvw_input_rumus_lp_balok)
        val tvwHasilLpBalok : TextView = findViewById(R.id.tvw_hasil_lp_balok)

        //inisialisasi button kembali
        btnBack.setOnClickListener {
            startActivity(Intent(this, BangunRuangActivity::class.java))
        }

        //inisialisasi button untuk error handling dan perhitungan
        btnHitung.setOnClickListener {
            if (edtPanjang.text.toString().isEmpty()){
                edtPanjang.setError("Panjang Tidak Boleh Kosong")
            }else if (edtLebar.text.toString().isEmpty()){
                edtLebar.setError("Lebar Tidak Boleh Kosong")
            }else if (edtTinggi.text.toString().isEmpty()){
                edtTinggi.setError("Tinggi Tidak Boleh Kosong")
            }else{
                val panjang = edtPanjang.text.toString().toFloat()
                val lebar = edtLebar.text.toString().toFloat()
                val tinggi = edtTinggi.text.toString().toFloat()
                val volumeHasil = VolumeBalok(panjang, lebar, tinggi)
                val lpHasil = LpBalok(panjang, lebar, tinggi)

                tvwRumusVolumeBalok.text = "       = $panjang × $lebar × $tinggi"
                tvwHasilVolumeBalok.text = "       = $volumeHasil"
                tvwRumusLpBalok.text = "  = 2×($panjang×$lebar+$panjang×$tinggi+$tinggi×$lebar)"
                tvwHasilLpBalok.text = "  = $lpHasil"
            }
        }
    }

    //fungsi untuk menghitung volume
    fun VolumeBalok(p: Float, l: Float, t: Float): Float{
        return p*l*t
    }

    //fungsi untuk menghitung laus permukaan
    fun LpBalok(p: Float, l: Float, t: Float): Float{
        return 2*(p*l+p*t+t*l)
    }
}