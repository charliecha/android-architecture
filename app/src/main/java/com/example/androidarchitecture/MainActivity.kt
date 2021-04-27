package com.example.androidarchitecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.viewbinding.ViewBindingActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.viewBinding).setOnClickListener{
            val intent = Intent(MainActivity@this, ViewBindingActivity::class.java)
            startActivity(intent)
        }
    }
}