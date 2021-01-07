package com.example.myapplication.BangunRuang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.myapplication.R

class TabungActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabung)

        //deklarasi view
        val btnBack : ImageButton = findViewById(R.id.btn_back_tabung)
        val btnHitung : Button = findViewById(R.id.btn_hitung_tabung)
        val edtRadius : EditText = findViewById(R.id.edt_input_radius_tabung)
        val edtTinggi : EditText = findViewById(R.id.edt_input_tinggi_tabung)
        val tvwRumusVolume : TextView = findViewById(R.id.tvw_input_rumus_volume_tabung)
        val tvwRumusLp : TextView = findViewById(R.id.tvw_input_rumus_lp_tabung)
        val tvwHasilVolume : TextView = findViewById(R.id.tvw_hasil_volume_tabung)
        val tvwHasilLp : TextView = findViewById(R.id.tvw_hasil_lp_tabung)

        //inisialisasi button untuk kembali
        btnBack.setOnClickListener {
            startActivity(Intent(this, BangunRuangActivity::class.java))
        }

        //inisialisasi button untuk error handling dan perhitungan
        btnHitung.setOnClickListener {
            if (edtRadius.text.toString().isEmpty()){
                edtRadius.setError("Radius Tidak Boleh Kosong")
            }else if(edtTinggi.text.toString().isEmpty()){
                edtTinggi.setError("Tinggi Tidak Boleh Kosong")
            }else{
                val r = edtRadius.text.toString().toFloat()
                val t = edtTinggi.text.toString().toFloat()
                val hasilVolume = VolumeTabung(r,t)
                val hasilLp = LpTabung(r,t)

                tvwRumusLp.text = " = 3.14 × $r² × $t"
                tvwRumusVolume.text = "   = 2×3.14×$r($r×$t)"
                tvwHasilLp.text = "   = $hasilLp"
                tvwHasilVolume.text = "  = $hasilVolume"
            }
        }
    }

    //fungsi untuk perhitungan volume
    fun VolumeTabung(r: Float, t: Float): Float{
        return 3.14f*(r*r)*t
    }

    //fungsi untuk perhitungan luas permukaan
    fun LpTabung(r: Float, t: Float): Float{
        return 2*3.14f*r*(r*t)
    }
}