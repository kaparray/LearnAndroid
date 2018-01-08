package com.kaparray.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button PrintHI;
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PrintHI = findViewById(R.id.button);
        final TextView textV =  findViewById(R.id.Etext);

        PrintHI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (count % 2 == 1) {
                    textV.setText("Hi");
                    count += 1;
                }
                else{
                    textV.setText("Bay!");
                    count += 1;
                }
            }
        });
    }
}


