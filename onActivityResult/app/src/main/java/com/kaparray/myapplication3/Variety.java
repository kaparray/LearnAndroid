package com.kaparray.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Variety extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variety);
    }

    public void onRadioClick(View v) {
        Intent answerIntent = new Intent();

        switch (v.getId()) {
            case R.id.radioProgrammer:
                answerIntent.putExtra("work", "Programmer");
                break;
            case R.id.radioLoh:
                answerIntent.putExtra("work", "Loh");
                break;
            case R.id.radioDvornic:
                answerIntent.putExtra("work", "Dvornik");
                break;
        }

        setResult(RESULT_OK, answerIntent);
        finish();
    }
}
