package com.example.android_day3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class ScreenOnReceive : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if(intent.action == Intent.ACTION_SCREEN_ON ){
            Log.d("dd","OK")
            val launchIntent = Intent(context,MainActivity::class.java)
            launchIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivities(arrayOf(launchIntent))
        }
    }
}