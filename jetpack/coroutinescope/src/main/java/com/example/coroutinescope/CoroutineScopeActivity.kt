package com.example.coroutinescope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinescope.ui.main.CoroutineScopeFragment

class CoroutineScopeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coroutine_scope_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CoroutineScopeFragment.newInstance())
                .commitNow()
        }
    }
}