package com.example.androidappmuseo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InitActivity extends AppCompatActivity {
    private ImageView imglogo;

    private Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        imglogo = findViewById(R.id.imageINTRO);
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }
    private void openActivity(){
        Intent intent = new Intent(this,MainActivity.class);//We call the second activity
        startActivity(intent);//Start
    }
}
