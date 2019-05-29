package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    Button btnPlay;
    MediaPlayer nhacnen = new MediaPlayer();
    CheckBox ktAmthanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setControl();
        setEvent();
    }

    private void setControl() {
        btnPlay = (Button) findViewById(R.id.btnPlay);
        ktAmthanh = (CheckBox) findViewById(R.id.checkBox1);
    }

    private void setEvent() {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

//        nhacnen = MediaPlayer.create(this, R.raw.nhacnenbaucua);
////
////        nhacnen.start();
////
////        ktAmthanh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
////
////            @Override
////            public void onCheckedChanged(CompoundButton arg0, boolean kt) {
////                if (kt) {
////                    nhacnen.stop();
////                } else {
////                    try {
////                        nhacnen.prepare();
////                        nhacnen.start();
////                    } catch (IllegalStateException e) {
////                        // TODO Auto-generated catch block
////                        e.printStackTrace();
////                    } catch (IOException e) {
////                        // TODO Auto-generated catch block
////                        e.printStackTrace();
////                    }
////                }
////            }
////        });
  }

}
