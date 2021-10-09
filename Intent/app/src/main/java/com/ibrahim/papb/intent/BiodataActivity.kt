package com.ibrahim.papb.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class BiodataActivity : AppCompatActivity() {

    private lateinit var tvNim : TextView
    private lateinit var tvHp : TextView
    private lateinit var tvAlamat : TextView
    private lateinit var tvJenisTinggal : TextView
    private lateinit var btnShare : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biodata)

        val bundle = intent.extras

        tvNim = findViewById(R.id.tvNimBio)
        tvHp = findViewById(R.id.tvHpBio)
        tvAlamat = findViewById(R.id.tvAlamatBio)
        tvJenisTinggal = findViewById(R.id.tvJenisTempatTinggalBio)
        btnShare = findViewById(R.id.btnShare)

        var extraText : String? = null

        bundle?.apply {
            tvNim.text = String.format("NIM : %s", this[DaftarActivity.NIM])
            tvHp.text = String.format("HP : %s", this[DaftarActivity.HP])
            tvAlamat.text = String.format("Alamat : %s", this[DaftarActivity.ALAMAT])
            tvJenisTinggal.text = String.format("Jenis Tinggal : %s", this[DaftarActivity.JENIS_TINGGAL])

            extraText = String.format("NIM : %s\nHP : %s\nAlamat : %s\nJenis Tinggal : %s",
                this[DaftarActivity.NIM],
                this[DaftarActivity.HP],
                this[DaftarActivity.ALAMAT],
                this[DaftarActivity.JENIS_TINGGAL])
        }


        btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                this.putExtra(Intent.EXTRA_TEXT, extraText)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(intent, "Share Biodata")
            startActivity(shareIntent)
        }
    }
}