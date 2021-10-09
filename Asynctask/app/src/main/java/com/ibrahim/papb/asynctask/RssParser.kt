package com.ibrahim.papb.asynctask

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import org.w3c.dom.Element
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory

class RssParser {

    private val TAG_ITEM = "item"
    private val TAG_TITLE = "title"
    private val TAG_CHANNEL = "channel"

    fun parseRssFromUrl(xml : String) : List<String> {
        Log.d("RSS_PARSER", "Running")
        val listItem = ArrayList<String>()
        val builder = DocumentBuilderFactory.newInstance()
        val db = builder.newDocumentBuilder()
        val inputSource = InputSource().apply {
            characterStream = StringReader(xml)
        }
        val document = db.parse(inputSource)
        val nodeList = document.getElementsByTagName(TAG_CHANNEL)
        val element = nodeList.item(0) as Element
        val items = element.getElementsByTagName(TAG_ITEM)

        for (i in 0 until items.length){
            val element1 = items.item(i) as Element
            val nodeList1 = element1.getElementsByTagName(TAG_TITLE)
            val child = nodeList1.item(0).firstChild
            val title = child.nodeValue
            listItem.add(title)
        }
        Log.d("RSS_PARSER", listItem.toString())
        return listItem
    }

}