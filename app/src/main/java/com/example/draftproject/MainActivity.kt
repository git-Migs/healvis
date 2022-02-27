package com.example.draftproject

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.TextUtils
import android.view.TextureView
import android.view.View
import android.widget.EditText
import androidx.core.view.isEmpty
import androidx.databinding.DataBindingUtil
import com.example.draftproject.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var editText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
//hello git

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        val intent =  Intent(this,VideoPresentation:: class.java )
        val newIntent = Intent (this, MainMenu:: class.java)

        binding.apply {
            editText = inputNamelayout

        btnNext.setOnClickListener {
            if (TextUtils.isEmpty(editText.text.toString())) {
                onAlertDialog(view)
                setContentView(view)
            }

            else {
                startActivity(intent);

            }



        }



        }

    }

    fun onAlertDialog (view: View){
        val builder = AlertDialog.Builder(view.context)

        builder.setTitle("Oops!")
        builder.setMessage("You forgot to insert your username.")
        builder.setNegativeButton("Close") { dialog, id ->
            }

        builder.show()
    }



}