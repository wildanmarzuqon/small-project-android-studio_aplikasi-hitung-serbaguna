package com.example.myapplication.KonversiNilai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class KonversiNilaiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konversi_nilai)

        //deklarasi variable  view
        val edtNilaiPartisipasi : EditText = findViewById(R.id.edt_nilai_partisipasi_konversi_nilai)
        val edtNilaiKehadiran : EditText = findViewById(R.id.edt_nilai_kehadiran_konversi_nilai)
        val edtNilaiTugas : EditText = findViewById(R.id.edt_nilai_tugas_konversi_nilai)
        val btnKonversi : ImageButton = findViewById(R.id.btn_koversi_nilai)
        val tvwNilaiAngka : TextView = findViewById(R.id.tvw_nilai_angka_konversi_nilai)
        val tvwNilaiHuruf : TextView = findViewById(R.id.tvw_nilai_huruf_konversi_nilai)
        val btnClose : ImageButton = findViewById(R.id.btn_close_konversi_nilai)

        //menambahkan fungsi click pada image button untuk kembali ke home
        btnClose.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        //menambahkan fungsi click pada image button untuk melakukan perhitungan error handling
        btnKonversi.setOnClickListener{
            //error handling ketika edittext masih belum terisi
            if (edtNilaiPartisipasi.text.toString().isEmpty()){
                edtNilaiPartisipasi.setError("Tidak Boleh Kosong")
            }else if (edtNilaiKehadiran.text.toString().isEmpty()){
                edtNilaiKehadiran.setError("Tidak Boleh Kosong")
            }else if (edtNilaiTugas.text.toString().isEmpty()){
                edtNilaiTugas.setError("Tidak Boleh Kosong")
            }
            //error handling untuk nilai diatas 100
            else if (edtNilaiPartisipasi.text.toString().toInt() > 100){
                edtNilaiPartisipasi.setError("Nilai Melebihi Batas")
            }else if (edtNilaiKehadiran.text.toString().toInt() > 100){
                edtNilaiKehadiran.setError("Nilai Melebihi Batas")
            }else if (edtNilaiTugas.text.toString().toInt() > 100){
                edtNilaiTugas.setError("Nilai Melebihi Batas")
            }else{
                //deklarasi variable menyimpan nilai edittext yang parse ke bentuk float
                val nilaiPartisipasi = edtNilaiPartisipasi.text.toString().toFloat()
                val nilaiKehadiran = edtNilaiKehadiran.text.toString().toFloat()
                val nilaiTugas = edtNilaiTugas.text.toString().toFloat()

                //deklarasi variabel untuk menyimpan nilai fungsi perhitungan nilai
                val hasilAngka = NilaiAkhir(nilaiPartisipasi,nilaiKehadiran,nilaiTugas)

                //memasuka nilai angka kedalam textview
                tvwNilaiAngka.text = hasilAngka.toInt().toString()

                //menambahkan nilai huruf ke textview berdasarkan nilai angka
                if (hasilAngka > 81){
                    tvwNilaiHuruf.text = "A"
                } else if (hasilAngka < 81 && hasilAngka > 75){
                    tvwNilaiHuruf.text = "B+"
                } else if (hasilAngka < 75 && hasilAngka > 71){
                    tvwNilaiHuruf.text = "B"
                } else if (hasilAngka < 71 && hasilAngka > 65){
                    tvwNilaiHuruf.text = "C+"
                }  else if (hasilAngka < 65 && hasilAngka > 61){
                    tvwNilaiHuruf.text = "C-"
                } else if (hasilAngka < 61 && hasilAngka > 55){
                    tvwNilaiHuruf.text = "C"
                } else if (hasilAngka < 55 && hasilAngka > 51){
                    tvwNilaiHuruf.text = "D"
                } else if (hasilAngka < 51 && hasilAngka > 0){
                    tvwNilaiHuruf.text = "E"
                }
            }
        }
    }
    //perhitungan nilai angka
    fun NilaiAkhir(nilaiPartisipasi : Float, nilaiKehadiran : Float, nilaiTugas : Float):Float{
        return (nilaiPartisipasi*30/100)+(nilaiKehadiran*30/100)+(nilaiTugas*40/100)
    }

}