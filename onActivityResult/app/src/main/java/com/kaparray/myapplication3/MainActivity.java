package com.kaparray.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final private int CHOOSE_THIEF = 0;
    protected Button variarity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        variarity = findViewById(R.id.Go_to_variarity);

        variarity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_to_variarity = new Intent(MainActivity.this, Variety.class);
                startActivityForResult(intent_to_variarity, CHOOSE_THIEF);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView infoTextView = (TextView) findViewById(R.id.you);

        if (requestCode == CHOOSE_THIEF) {
            if (resultCode == RESULT_OK) {
                String yours_profession = data.getStringExtra("work");
                infoTextView.setText(yours_profession);
            }else {
                infoTextView.setText(""); // стираем текст
            }
        }
    }

}
