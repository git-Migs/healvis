package com.example.draftproject

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.annotation.RequiresApi

import com.example.draftproject.databinding.ActivityMedicineScheduleBinding
import com.example.draftproject.ui.*
import java.util.*

class MedicineSchedule : AppCompatActivity() {
private lateinit var  binding: ActivityMedicineScheduleBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    binding = ActivityMedicineScheduleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotifcationChannel()
        }

        binding.apply {
        btnSchedule.setOnClickListener {
        }
        scheduleNotifcation()
        }
    }

    private fun scheduleNotifcation(){
        val intent = Intent(applicationContext, MedicineNotification::class.java)
        val title = binding.txtMedicineText.text.toString()
        val message = binding.txtMessageText.text.toString()
        intent.putExtra(titleExtra, title)
        intent.putExtra(messageExtra,message)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext, notificationId,intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP, time, pendingIntent
            )
        }
        showAlert (time, title, message)

    }

    private fun showAlert(time: Long, title: String, message: String) {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(applicationContext)


        AlertDialog.Builder(this)
            .setTitle("Medicine Scheduled")
            .setMessage("\nTitle: " + title +
                    "\nMessage" +message +
                    "\nAt: " +dateFormat.format(date) + " " + timeFormat.format(date))
            .setPositiveButton("Noted"){_,_->}
            .show()
    }

    @SuppressLint("NewApi")
    private fun getTime(): Long {
        val minute = binding.TimePicker.minute
        val hour = binding.TimePicker.hour
        val day = binding.DatePicker.dayOfMonth
        val  month = binding.DatePicker.month
        val year = binding.DatePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }

    @SuppressLint("NewApi")
    private fun createNotifcationChannel(){

        val name = "Notification Channel"
        val description = "Description of the Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelID, name, importance)
        channel.description = description

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}