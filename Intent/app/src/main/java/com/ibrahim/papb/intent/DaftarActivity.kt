package com.ibrahim.papb.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import com.google.android.material.button.MaterialButton

class DaftarActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    companion object{
        const val NIM = "NIM"
        const val HP = "HP"
        const val ALAMAT = "ALAMAT"
        const val JENIS_TINGGAL = "JENIS_TINGGAL"
    }

    private lateinit var etNim : EditText
    private lateinit var etHp : EditText
    private lateinit var etNama : EditText
    private lateinit var etAlamat : EditText
    private lateinit var btnSimpan : MaterialButton
    private lateinit var spinner : Spinner

    var jenisTinggal : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        etNim = findViewById(R.id.etNimDaftar)
        etHp = findViewById(R.id.etHpDaftar)
        etNama = findViewById(R.id.etNamaDaftar)
        etAlamat = findViewById(R.id.etAlamatDaftar)
        btnSimpan = findViewById(R.id.btnSimpanDaftar)
        spinner = findViewById(R.id.spinnerJenisTempatTinggal)

        ArrayAdapter.createFromResource(
            this,
            R.array.jenis_rumah,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = this

        btnSimpan.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(NIM, etNim.text.toString())
            bundle.putString(HP, etHp.text.toString())
            bundle.putString(ALAMAT, etAlamat.text.toString())
            bundle.putString(JENIS_TINGGAL, jenisTinggal)

            val intentToBiodata = Intent(this, BiodataActivity::class.java)
            intentToBiodata.putExtras(bundle)

            startActivity(intentToBiodata)
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        jenisTinggal = p0!!.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        // Nothing implemented
    }
}