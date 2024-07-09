package com.example.projem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Testler extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testler);
    }
    public void geri(View v) {
        Intent intent = new Intent(Testler.this, MainActivity.class);
        startActivity(intent);
    }
    public void test1(View v) {
        Intent intent = new Intent(Testler.this, Test1_1.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
    public void test2(View v) {
        Intent intent = new Intent(Testler.this, Test1_2.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
    public void test3(View v) {
        Intent intent = new Intent(Testler.this, Test1_3.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
    public void test4(View v) {
        Intent intent = new Intent(Testler.this, Test1_4.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
    public void test5(View v) {
        Intent intent = new Intent(Testler.this, Test2_1.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
    public void test6(View v) {
        Intent intent = new Intent(Testler.this, Test2_2.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
    public void test7(View v) {
        Intent intent = new Intent(Testler.this, Test2_3.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
    public void test8(View v) {
        Intent intent = new Intent(Testler.this, Test2_4.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
    public void test9(View v) {
        Intent intent = new Intent(Testler.this, Test3_1.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
    public void test10(View v) {
        Intent intent = new Intent(Testler.this, Test3_2.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
    public void test11(View v) {
        Intent intent = new Intent(Testler.this, Test3_3.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
    public void test12(View v) {
        Intent intent = new Intent(Testler.this, Test3_4.class);
        startActivity(intent);
        Toast.makeText(this, "Başarılar!", Toast.LENGTH_SHORT).show();
    }
}