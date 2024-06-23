package com.example.pember2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View


class hal2: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hal2)
    }
    fun KeProfil(view : View) {
        val intent = Intent(this, hal3::class.java)
        startActivity(intent) }

}