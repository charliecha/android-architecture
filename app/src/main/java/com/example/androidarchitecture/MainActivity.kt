package com.example.androidarchitecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lifecycle.LifeCycleActivity
import com.example.lifecycle.MyLifeCycleActivity
import com.example.livedata.LiveDataActivity
import com.example.viewbinding.ViewBindingActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.viewBinding).setOnClickListener{
            val intent = Intent(MainActivity@this, ViewBindingActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.lifecycle).setOnClickListener{
            val intent = Intent(MainActivity@this, MyLifeCycleActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.livedata).setOnClickListener{
            val intent = Intent(MainActivity@this, LiveDataActivity::class.java)
            startActivity(intent)
        }
    }
}