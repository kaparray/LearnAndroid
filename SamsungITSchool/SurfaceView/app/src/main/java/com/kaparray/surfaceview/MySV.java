package com.kaparray.surfaceview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class MySV extends SurfaceView implements SurfaceHolder.Callback{

    SurfaceHolder holder;
    private DrawThread drawThread;
    float x1 = 0;
    float y1 = 0;
    float x2 = 0;
    float y2 = 0;
    boolean pressed = false;
    int t = 1;

    public boolean onTouchEvent(MotionEvent event){
        if (t % 2 != 1) {
            x1 = event.getX();
            y1 = event.getY();
        }else {
            x2 = event.getX();
            y2 = event.getY();
        }
        pressed = true;
        return super.onTouchEvent(event);
    }

    public MySV(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        p.setColor(Color.GREEN);
    }


    public class DrawThread extends Thread {

        @Override
        public void run() {
            super.run();
            while (true){

                Canvas canvas = holder.lockCanvas();
                canvas.drawColor(Color.BLUE);
                if (pressed){
                    canvas.drawRect(y1,x1,y2,x2,p);

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }


    Paint p = new Paint();


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawThread = new DrawThread();
        drawThread.start();
        Color.argb(0,0,255,0);


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
