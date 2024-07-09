package com.example.projem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    ImageView ivFacebook, ivTwitter, ivInstagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivFacebook = findViewById(R.id.iv_facebook);
        ivTwitter = findViewById(R.id.iv_twitter);
        ivInstagram = findViewById(R.id.iv_instagram);
        ivFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sAppLink = "https://www.facebook.com";
                String sPackage = "com.facebook.katana";
                String sWebLink = "https://www.facebook.com";
                openLink(sAppLink, sPackage, sWebLink);
            }
        });

        ivInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sAppLink = "https://www.instagram.com";
                String sPackage = "com.instagram.android";
                openLink(sAppLink, sPackage, sAppLink);
            }
        });

        ivTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sAppLink = "https://www.twitter.com";
                String sPackage = "com.twitter.android";
                String sWebLink = "https://www.twitter.com";
                openLink(sAppLink, sPackage, sWebLink);
            }
        });
        getSupportActionBar().hide();
    }
    private void openLink(String sAppLink, String sPackage, String sWebLink) {
        try {
            Uri uri = Uri.parse(sAppLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(sPackage);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException activityNotFoundException) {
            Uri uri = Uri.parse(sWebLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
    public void ayarlar(View v) {
        Intent intent = new Intent(MainActivity.this, Ayarlar.class);
        startActivity(intent);
    }
    public void testler(View v) {
        Intent intent = new Intent(MainActivity.this, Testler.class);
        startActivity(intent);
    }
    public void ders1(View v) {
        Intent intent = new Intent(MainActivity.this, Ders1.class);
        startActivity(intent);
    }
    public void ders2(View v) {
        Intent intent = new Intent(MainActivity.this, Ders2.class);
        startActivity(intent);
    }
    public void ders3(View v) {
        Intent intent = new Intent(MainActivity.this, Ders3.class);
        startActivity(intent);
    }
    public void ders4(View v) {
        Intent intent = new Intent(MainActivity.this, Ders4.class);
        startActivity(intent);
    }
    public void ders5(View v) {
        Intent intent = new Intent(MainActivity.this, Ders5.class);
        startActivity(intent);
    }
}