package com.ibrahim.papb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var tvItemDetail : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val extras = intent.extras

        tvItemDetail = findViewById(R.id.tvItemDetail)
        tvItemDetail.text = extras!!.getString(ItemAdapter.ITEM_NAME)
    }
}