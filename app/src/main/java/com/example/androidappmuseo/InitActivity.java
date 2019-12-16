package com.example.androidappmuseo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InitActivity extends AppCompatActivity {
    private ImageView imglogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        imglogo = findViewById(R.id.imageINTRO);

        new Handler().postDelayed(new Runnable() { // To do the splash
            @Override
            public void run() {
                Intent intent = new Intent(InitActivity.this,MainActivity.class);//We call the second activity
                startActivity(intent);//Start
                finish();

            }
        },2000);//ms

    }

}
