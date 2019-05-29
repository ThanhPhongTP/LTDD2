package com.example.naochiennhom2;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    ImageView logo;
    ProgressBar pbLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setControl();
        setEvent();
    }

    private void setControl() {
        logo = (ImageView)findViewById(R.id.logo);
       pbLoading = (ProgressBar)findViewById(R.id.pbLoading);

//        Thread timer = new Thread() {
//            public void run() {
//                try {
//                    sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                finally {
//                    startActivity(intent);
//                    finish();
//                }
//
//            }
//        };
//        timer.start();
    }


    public void setEvent(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splashscreen);
        logo.startAnimation(animation);
        final Intent intent = new Intent(this, MainActivity.class);
        CountDownTimer countDownTimer = new CountDownTimer(6000, 35) {
            @Override
            public void onTick(long millisUntilFinished) {
                int current = pbLoading.getProgress();
                pbLoading.setProgress(current + 1);
            }

            @Override
            public void onFinish() {
                startActivity(intent);
                finish();
            }
        };
        countDownTimer.start();
    }
}
