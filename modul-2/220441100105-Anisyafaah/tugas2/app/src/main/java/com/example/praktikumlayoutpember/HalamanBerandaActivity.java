package com.example.praktikumlayoutpember;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HalamanBerandaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_beranda);
    }

    public void KeProfile(View view) {
        Intent b = new Intent(this, HalamanProfileActivity.class);
        startActivity(b);
    }
}
