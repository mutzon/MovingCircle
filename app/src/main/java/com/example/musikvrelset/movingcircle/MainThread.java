package com.example.musikvrelset.movingcircle;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private Circle circle;

    public MainThread(SurfaceHolder surfaceHolder, Circle circle) {
        this.surfaceHolder = surfaceHolder;
        this.circle = circle;
    }

    public void run() {
        Canvas canvas = null;

        while (true) {

            try {
                canvas = surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder) {
                    circle.clearCircle(canvas);
                    circle.moveCircle();
                    circle.onDraw(canvas);
                }
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

        }
    }
}
