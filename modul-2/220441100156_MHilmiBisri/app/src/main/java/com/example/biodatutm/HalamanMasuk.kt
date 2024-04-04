package com.example.biodatutm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halamanmasuk)
        val inputan = Inputan(this)
        inputan.tombol()
    }
}
class Inputan(private val activity: AppCompatActivity) {

    fun tombol() {
        val button = activity.findViewById<Button>(R.id.lanjut)
        button.setOnClickListener {
            val nama = kolom()
            val intent = Intent(activity, Beranda::class.java)
            intent.putExtra("kolom", nama)
            activity.startActivity(intent)
        }
    }

    fun kolom(): String {
        val editText = activity.findViewById<EditText>(R.id.KolomNama)
        return editText.text.toString()
    }
}