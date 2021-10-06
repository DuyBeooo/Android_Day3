package com.example.android_day3

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private val screenOn = ScreenOnReceive()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Exe 1:
        val intent = IntentFilter("android.intent.action.SCREEN_ON")
        registerReceiver(screenOn, intent)

        // Exe 2+3:
        buttonSendClicked()
        buttonCheckClicked()
    }

    private val list = mutableListOf("A", "B", "C", "D", "E")

    data class Data(val list: List<String>) : Serializable

    private fun buttonSendClicked() {
        findViewById<Button>(R.id.btnSend).setOnClickListener {
            val data = Data(list)
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("keys", data)
            startActivity(intent)
        }

    }

    private fun buttonCheckClicked() {
        findViewById<Button>(R.id.btnSecondActivity).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onDestroy() {
        unregisterReceiver(screenOn)
        super.onDestroy()
    }
}