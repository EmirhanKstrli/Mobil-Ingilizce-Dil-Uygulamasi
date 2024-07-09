package com.example.projem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kaynak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kaynak);
    }

    public void geri(View v) {
        Intent intent = new Intent(Kaynak.this, Ayarlar.class);
        startActivity(intent);
    }

}