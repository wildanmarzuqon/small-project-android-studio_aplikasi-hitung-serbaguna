package com.example.myapplication.BeratIdeal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class BeratIdealActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berat_ideal)

        //deklarasi variabel view
        var edtTinggiBadan : EditText = findViewById(R.id.edt_tinggi_berat_ideal)
        var edtBeratBadan : EditText = findViewById(R.id.edt_berat_berat_ideal)
        val btnHitungBeratIdeal : Button = findViewById(R.id.btn_hitung_berat_ideal)
        val btnHomeBeratIdeal : ImageButton = findViewById(R.id.imgbtn_home_berat_ideal)
        val tvwIMT : TextView = findViewById(R.id.tvw_imt_hasil)
        val tvwBeratIdealPria : TextView = findViewById(R.id.tvw_berat_ideal_pria_hasil)
        val tvwBeratIdealWanita : TextView = findViewById(R.id.tvw_berat_ideal_wanita_hasil)

        //membuat click button untuk kembali ke MainActivity
        btnHomeBeratIdeal.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        //mmebuat click button untuk melakukan perhitungan dan error handling
        btnHitungBeratIdeal.setOnClickListener {
            if(edtTinggiBadan.text.toString().isEmpty()){
                edtTinggiBadan.setError("Tidak Boleh Kosong")
            }else if (edtBeratBadan.text.toString().isEmpty()){
                edtBeratBadan.setError("Tidak Boleh Kosong")
            }else{
                val nilaiImt = HitungIMT(edtTinggiBadan.text.toString().toFloat(), edtBeratBadan.text.toString().toFloat())
                val beratPria = HitungBeratIdealPria(edtTinggiBadan.text.toString().toInt())
                val beratWanita = HitungBeratIdealWanita(edtTinggiBadan.text.toString().toInt())

                if (nilaiImt < 18){
                    tvwIMT.text = "Nilai IMT anda adalah $nilaiImt, berat badan anda kurang."
                    tvwBeratIdealPria.text = "Berat badan ideal untuk pria deangan tinggi ${edtTinggiBadan.text} CM adalah $beratPria KG"
                    tvwBeratIdealWanita.text = "Berat badan ideal untuk wanita dengan tinggi ${edtTinggiBadan.text} CM adalah $beratWanita KG"
                } else if (nilaiImt > 18 && nilaiImt < 25){
                    tvwIMT.text = "Nilai IMT anda adalah $nilaiImt, berat badan anda ideal."
                    tvwBeratIdealPria.text = "Berat badan ideal untuk pria deangan tinggi ${edtTinggiBadan.text} CM adalah $beratPria KG"
                    tvwBeratIdealWanita.text = "Berat badan ideal untuk wanita dengan tinggi ${edtTinggiBadan.text} CM adalah $beratWanita KG"
                } else if (nilaiImt > 25 && nilaiImt < 30){
                    tvwIMT.text = "Nilai IMT anda adalah $nilaiImt, berat badan anda lebih."
                    tvwBeratIdealPria.text = "Berat badan ideal untuk pria deangan tinggi ${edtTinggiBadan.text} CM adalah $beratPria KG"
                    tvwBeratIdealWanita.text = "Berat badan ideal untuk wanita dengan tinggi ${edtTinggiBadan.text} CM adalah $beratWanita KG"
                }else if (nilaiImt > 30 && nilaiImt < 40){
                    tvwIMT.text = "Nilai IMT anda adalah $nilaiImt, anda mengalami obesitas."
                    tvwBeratIdealPria.text = "Berat badan ideal untuk pria deangan tinggi ${edtTinggiBadan.text} CM adalah $beratPria KG"
                    tvwBeratIdealWanita.text = "Berat badan ideal untuk wanita dengan tinggi ${edtTinggiBadan.text} CM adalah $beratWanita KG"
                }else if (nilaiImt > 40){
                    tvwIMT.text = "Nilai IMT anda adalah $nilaiImt, segera perisakan ke dokter"
                    tvwBeratIdealPria.text = "Berat badan ideal untuk pria deangan tinggi ${edtTinggiBadan.text} CM adalah $beratPria KG"
                    tvwBeratIdealWanita.text = "Berat badan ideal untuk wanita dengan tinggi ${edtTinggiBadan.text} CM adalah $beratWanita KG"
                }
            }
        }
    }

    //fungsi perhtungan mit
    fun HitungIMT(tinggi : Float, berat :Float):Float{
        val tinggiMeter = tinggi/100
        return berat/(tinggiMeter*tinggiMeter)
    }

    //fungsi perhitunagn berat ideal pria
    fun HitungBeratIdealPria(tinggi: Int):Int{
        return (tinggi-100)-((tinggi-100)*10/100)
    }

    //fungsi perhitungan berat ideal wanita
    fun HitungBeratIdealWanita(tinggi: Int): Int{
        return (tinggi-100)-((tinggi-100)*15/100)
    }
}