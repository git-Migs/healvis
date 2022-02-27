package com.example.draftproject

import android.app.AlarmManager
import android.app.Notification
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.AlarmManagerCompat
import androidx.core.app.NotificationCompat
import com.example.draftproject.databinding.ActivityDrinkWaterBinding
class DrinkWater : AppCompatActivity() {

    private lateinit var binding: ActivityDrinkWaterBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        var builder = NotificationCompat.Builder(this,"Drink Notification" )
            .setSmallIcon(R.drawable.cupwater)
            .setContentTitle("Drink Alarm!!!")
            .setContentText("Time for you to drink some water.")
            .setStyle(NotificationCompat.BigTextStyle().bigText("Stay Hydrated"))
            .setPriority(Notification.PRIORITY_DEFAULT)




        binding = ActivityDrinkWaterBinding.inflate(layoutInflater)

        val  view =binding.root
        setContentView(view)

        binding.apply {
            btnActivateAlarm.setOnClickListener {




            }
        }






    }

}


