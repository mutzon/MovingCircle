package com.example.musikvrelset.movingcircle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Circle extends SurfaceView implements SurfaceHolder.Callback {

    private float x;
    private float y;
    private int radius;
    private Paint paint;
    private MainThread thread;
    private boolean movingRight = true;

    public Circle(Context context, float x, float y, int radius) {
        super(context);

        this.x = x;
        this.y = y;
        this.radius = radius;

        // Tell the SurfaceHolder ( -> getHolder() ) to receive SurfaceHolder
        // callbacks
        getHolder().addCallback(this);
        this.thread = new MainThread(getHolder(), this);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
    }

    // Specify wheater to move right or left
    public void moveCircle() {

        if (this.movingRight) {
            this.x++;
        } else {
            this.x--;
        }

        if (this.x == (getWidth() - this.radius)) {
            this.movingRight = false;
        } else if (this.x == (0 + this.radius)) {
            this.movingRight = true;
        }

    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(this.x, this.y, this.radius, this.paint);
    }

    public void clearCircle(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        // TODO Auto-generated method stub
    }
}
