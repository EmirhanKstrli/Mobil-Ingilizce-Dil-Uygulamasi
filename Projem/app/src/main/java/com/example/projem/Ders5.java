package com.example.projem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Ders5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ders5);
    }
    public void geri(View v) {
        Intent intent = new Intent(Ders5.this, MainActivity.class);
        startActivity(intent);
    }
}