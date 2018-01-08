package com.kaparray.myapplication2;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    protected LinearLayout main;
    protected Button GreenLight;
    protected Button YellowLight;
    protected Button RedLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = (LinearLayout) findViewById(R.id.Main);
        GreenLight = findViewById(R.id.Green);
        YellowLight = findViewById(R.id.Yellow);
        RedLight = findViewById(R.id.Red);

        GreenLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setBackgroundColor(ContextCompat
                        .getColor(MainActivity.this, R.color.Green));
            }
        });

        RedLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setBackgroundColor(ContextCompat
                        .getColor(MainActivity.this, R.color.Red));
            }
        });

        YellowLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setBackgroundColor(ContextCompat
                        .getColor(MainActivity.this, R.color.Yellow));
            }
        });

    }
}
