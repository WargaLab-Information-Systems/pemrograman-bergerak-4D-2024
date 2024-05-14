package com.example.biodatutm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Beranda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beranda)
        val nama = HMExtra(this).nama()
        val profil = Profil(this)
        profil.logo()

    }
}
class HMExtra(private val activity: AppCompatActivity) {
    fun nama(): String {
        return activity.intent.getStringExtra("kolom").toString()
    }
}
class Profil(private val activity: AppCompatActivity) {

    fun logo() {
        val logoIV = activity.findViewById<ImageView>(R.id.logo)
        logoIV.setOnClickListener {
            val intent = Intent(activity, Profile::class.java)
            activity.startActivity(intent)
        }
    }

}
