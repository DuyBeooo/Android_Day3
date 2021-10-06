package com.example.android_day3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        getData()
    }

    private fun getData() {
        val data = intent.extras?.get("keys")
        findViewById<TextView>(R.id.tvList).text = data.toString()
    }

}