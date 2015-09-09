package com.example.musikvrelset.movingcircle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MovingCircle extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This is the only line you need to add.
        //We place our UI with the setContentView method
        setContentView(new Circle(this, 50, 50, 25));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_moving_circle, menu);
        return true;
    }
}


