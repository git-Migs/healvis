package com.example.draftproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.example.draftproject.databinding.ActivityVideoPresentationBinding

class VideoPresentation : AppCompatActivity() {
    private lateinit var binding: ActivityVideoPresentationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_presentation)

        binding = ActivityVideoPresentationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent =  Intent(this,MainMenu:: class.java )
        val offlineUri = Uri.parse("android.resource://$packageName/${R.raw.intro}")
        val mediaController = MediaController(this)

        binding.apply {

            mediaController.setAnchorView(vvIntro)

            vvIntro.setMediaController(mediaController)
            vvIntro.setVideoURI(offlineUri)
            vvIntro.requestFocus()
            vvIntro.start()

            btnSkip.setOnClickListener {
                startActivity(intent);
            }
        }
    }
}