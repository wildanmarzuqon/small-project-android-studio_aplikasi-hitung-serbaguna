package com.example.myapplication.KonversiSuhu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import kotlin.math.ceil


class KonversiSuhuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konversi_suhu)

        //deklarasi view
        val spnSuhu : Spinner = findViewById(R.id.spn_suhu_list)
        val spnSuhuHasil : Spinner = findViewById(R.id.spn_suhu_list_hasil)
        val edtInputSuhu : EditText = findViewById(R.id.edt_input_konversi_suhu)
        val tvwOutputSuhu : TextView = findViewById(R.id.tvw_output_konversi_suhu)
        val btnKonversiSuhu : ImageButton = findViewById(R.id.btn_konversi_suhu)
        val btnClose : ImageButton = findViewById(R.id.btn_close_koversi_suhu)

        //inisialisasi button untuk error handling dan perhitunngan
        btnKonversiSuhu.setOnClickListener {
            if (edtInputSuhu.text.toString().isEmpty()){
                edtInputSuhu.setError("Nilai Tidak Boleh Kosong")
            }else if (spnSuhu.selectedItem.toString() == "Celsius" && spnSuhuHasil.selectedItem.toString() == "Fahrenheit"){
                tvwOutputSuhu.text = CelciusToFahrenheit(edtInputSuhu.text.toString().toInt()).toString()
            }else if (spnSuhu.selectedItem.toString() == "Celsius" && spnSuhuHasil.selectedItem.toString() == "Kelvin"){
                tvwOutputSuhu.text = CelciusToKelvin(edtInputSuhu.text.toString().toInt()).toString()
            }else if (spnSuhu.selectedItem.toString() == "Celsius" && spnSuhuHasil.selectedItem.toString() == "Reamur"){
                tvwOutputSuhu.text = CelciusToReamur(edtInputSuhu.text.toString().toInt()).toString()
            }else if (spnSuhu.selectedItem.toString() == "Reamur" && spnSuhuHasil.selectedItem.toString() == "Celcius"){
                tvwOutputSuhu.text = ReamurToCelcius(edtInputSuhu.text.toString().toInt()).toString()
            }else if (spnSuhu.selectedItem.toString() == "Reamur" && spnSuhuHasil.selectedItem.toString() == "Kelvin"){
                tvwOutputSuhu.text = ReamurToKelvin(edtInputSuhu.text.toString().toInt()).toString()
            }else if (spnSuhu.selectedItem.toString() == "Reamur" && spnSuhuHasil.selectedItem.toString() == "Fahrenheit"){
                tvwOutputSuhu.text = ReamurToFarenheit(edtInputSuhu.text.toString().toInt()).toString()
            }else if (spnSuhu.selectedItem.toString() == "Fahrenheit" && spnSuhuHasil.selectedItem.toString() == "Celcius"){
                tvwOutputSuhu.text = FahrenheitToCelcius(edtInputSuhu.text.toString().toInt()).toString()
            }else if (spnSuhu.selectedItem.toString() == "Fahrenheit" && spnSuhuHasil.selectedItem.toString() == "Reamur"){
                tvwOutputSuhu.text = FahrenheitToReamur(edtInputSuhu.text.toString().toInt()).toString()
            }else if (spnSuhu.selectedItem.toString() == "Fahrenheit" && spnSuhuHasil.selectedItem.toString() == "Kelvin"){
                tvwOutputSuhu.text = FahrenheitToKelvin(edtInputSuhu.text.toString().toInt()).toString()
            }else if (spnSuhu.selectedItem.toString() == "Kelvin" && spnSuhuHasil.selectedItem.toString() == "Celcius"){
                tvwOutputSuhu.text = KelvinToCelcius(edtInputSuhu.text.toString().toInt()).toString()
            }else if (spnSuhu.selectedItem.toString() == "Kelvin" && spnSuhuHasil.selectedItem.toString() == "Reamur"){
                tvwOutputSuhu.text = KelvinToReamur(edtInputSuhu.text.toString().toInt()).toString()
            }else if (spnSuhu.selectedItem.toString() == "Kelvin" && spnSuhuHasil.selectedItem.toString() == "Fahrenheit"){
                tvwOutputSuhu.text = KelvinToFahrenheit(edtInputSuhu.text.toString().toInt()).toString()
            }else if(spnSuhu.selectedItem.toString() == "Celsius" && spnSuhuHasil.selectedItem.toString() == "Celsius"){
                tvwOutputSuhu.text = edtInputSuhu.text.toString()
            }else if(spnSuhu.selectedItem.toString() == "Reamur" && spnSuhuHasil.selectedItem.toString() == "Reamur"){
                tvwOutputSuhu.text = edtInputSuhu.text.toString()
            }else if(spnSuhu.selectedItem.toString() == "Kelvin" && spnSuhuHasil.selectedItem.toString() == "Kelvin"){
                tvwOutputSuhu.text = edtInputSuhu.text.toString()
            }else if(spnSuhu.selectedItem.toString() == "Fahrenheit" && spnSuhuHasil.selectedItem.toString() == "Fahrenheit"){
                tvwOutputSuhu.text = edtInputSuhu.text.toString()
            }
        }

        //inisialisasi button untuk berpindah activity
        btnClose.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    //fungsi untuk perhitungan suhu
    fun CelciusToReamur(c : Int): Double{
        val hasil = 0.8*c
        return ceil(hasil)
    }
    fun CelciusToKelvin(c : Int): Double {
        return c+273.0
    }
    fun CelciusToFahrenheit(c: Int): Double {
        return ceil(1.8*c+32)
    }
    fun ReamurToCelcius(r : Int): Double{
        return ceil(1.25*r)
    }
    fun ReamurToFarenheit(r : Int): Double{
        return ceil(2.25*r+32)
    }
    fun ReamurToKelvin(r : Int): Double{
        return ceil(1.25*r+273)
    }
    fun FahrenheitToCelcius(f : Int): Double{
        return ceil(0.555*(f-32))
    }
    fun FahrenheitToKelvin(f: Int): Double{
        return ceil(0.555*(f-32)+273)
    }
    fun FahrenheitToReamur(f: Int): Double{
        return ceil(0.444*(f-32))
    }
    fun KelvinToCelcius(k: Int): Double{
        return ceil(k-273.0)
    }
    fun KelvinToReamur(k: Int): Double{
        return ceil(0.8*(k-273))
    }
    fun KelvinToFahrenheit(k: Int): Double{
        return ceil(1.8*(k-273)+32)
    }
}