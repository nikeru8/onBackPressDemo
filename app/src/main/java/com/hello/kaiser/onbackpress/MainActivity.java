package com.hello.kaiser.onbackpress;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
    }

    int BackPress = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (event.getRepeatCount() == 0) {
                if (BackPress == 0) {
                    Toast.makeText(this, "再按一次離開", Toast.LENGTH_SHORT).show();
                    BackPress++;
                } else {//點擊超過一次以上
                    finish();
                }

                new Handler().postDelayed(new Runnable() {//兩秒後reset次數
                    @Override
                    public void run() {
                        BackPress = 0;
                    }
                }, 2000);

            } else {

                Log.d("checkpoint", "連點不動作 checkpoint - " + event.getRepeatCount());

            }


        }

        return super.onKeyDown(keyCode, event);
    }

}

