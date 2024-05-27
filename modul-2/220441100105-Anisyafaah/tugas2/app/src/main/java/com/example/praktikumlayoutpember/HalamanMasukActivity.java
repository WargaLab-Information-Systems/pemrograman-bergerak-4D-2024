package com.example.praktikumlayoutpember;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HalamanMasukActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_masuk);
    }

    public void KeBeranda(View view) {
        Intent a = new Intent(this,HalamanBerandaActivity.class);
        startActivity(a);
    }
}