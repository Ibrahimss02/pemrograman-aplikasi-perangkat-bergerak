package com.ibrahim.papb.asynctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val baseUrl = "https://medium.com/feed/tag/programming"
    private lateinit var button : Button
    private lateinit var rv : RecyclerView
    private lateinit var progressBar : ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressIndicator)
        button = findViewById(R.id.btnMain)
        rv = findViewById(R.id.mainRv)
        rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val rssLoader = LoadRss()


        button.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            rssLoader.execute(baseUrl)
            button.visibility = View.INVISIBLE
        }

        rssLoader.res.observe(this, {
            it?.let {
                progressBar.visibility = View.INVISIBLE
                val adapter = MainAdapter(it)
                rv.layoutManager = LinearLayoutManager(this)
                rv.adapter = adapter
            }
        })
    }
}