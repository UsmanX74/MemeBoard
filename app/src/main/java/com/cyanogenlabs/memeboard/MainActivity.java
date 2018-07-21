package com.cyanogenlabs.memeboard;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    MainView mView;
    public static int sW,sH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        sW = size.x;
        sH = size.y;
        super.onCreate(savedInstanceState);
        mView = new MainView(this);
        mView.setKeepScreenOn(true);
        mView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LOW_PROFILE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE);
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //to tell the system to make our app full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(mView);
    }
}
