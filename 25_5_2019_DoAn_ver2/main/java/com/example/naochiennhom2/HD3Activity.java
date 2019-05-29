package com.example.naochiennhom2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class HD3Activity extends AppCompatActivity {
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hd3);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HD3Activity.this, Round3Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                Bundle mydata = getIntent().getExtras();
                int diemKQ = mydata.getInt("diem2_1");
                intent.putExtra("diem3", diemKQ);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        btnStart = findViewById(R.id.btnstart1);
    }
}
