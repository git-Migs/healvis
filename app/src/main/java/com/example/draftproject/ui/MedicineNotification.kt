package com.example.draftproject.ui

import android.app.Notification
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.databinding.library.baseAdapters.R

const val  notificationId = 1
const val channelID = "Channel 1"
const val titleExtra = "Medicine"
const val messageExtra = "messageExtra"

class MedicineNotification : BroadcastReceiver ()
{

    override fun onReceive(context: Context, intent: Intent) {

        val notification : Notification = NotificationCompat.Builder(context, channelID)
            .setSmallIcon(R.drawable.notification_icon_background)
            .setContentTitle(intent.getStringExtra(titleExtra))
            .setContentText(intent. getStringExtra(messageExtra))
            .build()

        val  manager = context.getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
        manager.notify(notificationId, notification)

    }

}