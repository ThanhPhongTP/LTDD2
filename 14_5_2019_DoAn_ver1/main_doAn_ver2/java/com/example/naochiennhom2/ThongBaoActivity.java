package com.example.naochiennhom2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThongBaoActivity extends AppCompatActivity {

    TextView tvDiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);
        setControl();
        setEvent();
    }

    private void setEvent() {
        Intent intent = getIntent();
        tvDiem.setText(intent.getStringExtra(Round2Activity.truyenDiem));
    }

    private void setControl() {
        tvDiem = (TextView)findViewById(R.id.tvdiem);
    }


}
