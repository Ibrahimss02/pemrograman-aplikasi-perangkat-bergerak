package com.ibrahim.papb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain : RecyclerView
    private lateinit var btnAdd : MaterialButton
    private var listItem = arrayListOf(
        Item("Pemrograman Aplikasi Perangkat Bergerak"),
        Item("Pemrograman Dasar"),
        Item("Pemrograman Lanjut"),
        Item("Pemrograman Berorientasi Objek"),
        Item("Dasar Desain Antarmuka Pengguna"),
        Item("Pengantar Data Saintis"),
        Item("Manajemen Bisnis Fungsional"),
        Item("Statistika"),
        Item("Algoritma dan Struktur Data")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ItemAdapter(listItem, this)
        btnAdd = findViewById(R.id.btnAddMainList)
        btnAdd.setOnClickListener {
            /**
             * Mengambil item dari list yang ada secara random
             * kemudian ditambahkan "NEW!" pada akhirannya untuk dimasukkan
             * ke list RecyclerView sebagai item baru.
             */
            val index = (Math.random() * listItem.size).toInt()
            val newListItem = Item(listItem[index].nama + " NEW!")
            adapter.listItem.add(newListItem)
            adapter.notifyDataSetChanged()
        }

        rvMain = findViewById(R.id.rvMain)

        rvMain.layoutManager = LinearLayoutManager(this)
        rvMain.adapter = adapter
    }
}