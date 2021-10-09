package com.ibrahim.papb.asynctask

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.MutableLiveData
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception

class LoadRss : AsyncTask<String, Int, List<String>>() {

    val res = MutableLiveData(ArrayList<String>())

    override fun doInBackground(vararg p0: String?): List<String>? {
        Log.d("LOAD_RSS", "Running in background")
        val url = p0[0]
        val client = OkHttpClient()
        val request = Request.Builder().url(url!!).build()

        try {
            val response = client.newCall(request).execute()
            val xml = response.body!!.string()
            val parser = RssParser()
            val list = parser.parseRssFromUrl(xml)
            val itemList = ArrayList<String>()
            for (item in list){
                itemList.add(item)
            }
            return itemList
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    override fun onPostExecute(result: List<String>?) {
        super.onPostExecute(result)
        res.value = result as ArrayList<String>?
        Log.d("LOAD_RSS", res.value.toString())
    }
}