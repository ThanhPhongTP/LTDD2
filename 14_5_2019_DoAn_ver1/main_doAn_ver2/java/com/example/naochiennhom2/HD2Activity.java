package com.example.naochiennhom2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pl.droidsonroids.gif.GifTextView;

public class HD2Activity extends AppCompatActivity {
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hd2);
        setControl();
        setEvent();
    }

    private void setControl() {
        btnStart = (Button)findViewById(R.id.btnstart);

    }
    private void setEvent(){
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HD2Activity.this, Round2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
    }
}
