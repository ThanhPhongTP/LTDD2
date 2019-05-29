package com.example.naochiennhom2;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Round1Activity extends AppCompatActivity {

    CountDownTimer timer;
    TextView txtCauHoi, thoiGian, diem;
    int nKQ;
    Button btnA, btnB, btnC, btnD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round1);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setControl();
        setEvent();
    }

    private void setControl() {
        txtCauHoi = (TextView)findViewById(R.id.txtcauhoi);
        btnA = (Button)findViewById(R.id.a);
        btnB = (Button)findViewById(R.id.b);
        btnC = (Button)findViewById(R.id.c);
        btnD = (Button)findViewById(R.id.d);
        thoiGian = (TextView)findViewById(R.id.txttime);
        diem = (TextView)findViewById(R.id.txtdiem);
    }
    private void setEvent() {
        txtCauHoi.setText(loadCauHoi());
        //loadDapAn();

    }
    public String loadCauHoi()
    {
        String cauhoi = " ";

        int soa = 0 + (int)(Math.random()*((50-0)+1));
        int sob = 0 + (int)(Math.random()*((50-0)+1));

        int soc = soa+sob;


        String chuoisoa,chuoisob,chuoisoc;

        chuoisoa = String.valueOf(soa);
        chuoisob = String.valueOf(sob);
        //chuoisoc = String.valueOf(soc);

        nKQ=soc;

        return cauhoi = chuoisoa+ " + " + chuoisob +" = " ;
    }
    public String loadDapAn(){
        String s = "";
        int kq = 1 + (int)(Math.random()*((4-1)+1));
        switch (kq){
            case 1:
                btnA.setText(nKQ);
                break;
            case 2:
                btnB.setText(nKQ);
                break;
            case 3:
                btnC.setText(nKQ);
                break;
            case 4:
                btnD.setText(nKQ);
                break;
            default:
                break;
        }
        return s;
    }

    //Thoi gian dem nguoc
    @Override
    protected void onStart() {
        super.onStart();
        timer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                thoiGian.setText("Time: " + String .valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                thoiGian.setText("Time: 0");
                Intent intent = new Intent(Round1Activity.this, HD2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        }.start();
    }

}
