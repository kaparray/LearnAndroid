package com.kaparray.thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity   {

    TextView text;
//    MyHandler handler = new MyHandler();
//
//    class MyHandler extends Handler{
//        @Override
//        public void handleMessage(Message msg) {
//            text.setText(msg.arg1 + "");
//        }
//    }

    void setNum(int i){
        text.setText(i + "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        text = findViewById(R.id.tv_hello);
        new MyThread().start();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i <= 10; i++){

                // if you use fucking android use 1-st
//                Message m = new Message();
//                m.arg1 = i;
//                handler.sendMessage(m);
                final int finalI = i;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setNum(finalI);
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
