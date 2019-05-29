package com.example.naochiennhom2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Round2Activity extends AppCompatActivity {

    CountDownTimer timer;
    TextView diem, thoiGian;
    static String truyenDiem;
    GridView gridView;
    ImageView curView = null;
    private int countPair = 0;
    int score = 0;
    final int[] drawable = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n};
    int[] pos = {};
    int currentPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round2);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setControl();
        setEvent();
        onStart();
    }

    private void setControl() {
        gridView = (GridView)findViewById(R.id.gv);
        diem = (TextView)findViewById(R.id.txtdiem);
        thoiGian = (TextView)findViewById(R.id.txttime);
        Bundle mydata = getIntent().getExtras();
        int diemKQ = mydata.getInt("diem2");
        diem.setText(String.valueOf(diemKQ));

    }


    //int kq = 1 + (int)(Math.random()*((4-1)+1));
    private void setEvent() {
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.quay);
        setPos();
        final Handler handler = new Handler();

        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter((imageAdapter));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {

                if(currentPos < 0){
                    currentPos = position;

                    curView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                    ((ImageView)view).startAnimation(animation);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ((ImageView)view).setImageResource(R.drawable.lg);
                        }
                    }, 700);
                }
                else {
                    if(currentPos == position){
                        ((ImageView)view).setImageResource(R.drawable.lg);
                    }
                    else if (pos[currentPos] != pos[position]){
                        ((ImageView)view).startAnimation(animation);
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ((ImageView)view).setImageResource(R.drawable.lg);
                                //curView.setImageResource(R.drawable.brain_data);
                            }
                        }, 700);
                        Toast.makeText(getApplicationContext(),"Sai", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ((ImageView)view).setVisibility(View.INVISIBLE);
                                curView.setVisibility(View.INVISIBLE);
                                if(countPair == 6 || countPair == 12 || countPair == 18 || countPair == 24 || countPair == 30
                                        || countPair == 36 || countPair == 42){
                                    Toast.makeText(getApplicationContext(),"WIN", Toast.LENGTH_SHORT).show();
                                    setEvent();
                                }
                            }
                        }, 500);

                        countPair++;
                        score = Integer.parseInt(diem.getText().toString());
                        score += 10;
                        diem.setText(String.valueOf(score));
                    }
                    currentPos = -1;
                }
            }
        });

    }

    //Tao ngau nhien mang vi tri cua hinh anh(6 cap)
    private void setPos(){
        Random rd = new Random();
        int a = rd.nextInt(5);
        switch (a){
            case 0:
                pos = new int[]{1,0,4,1,2,3,3,0,4,2,5,5};
                break;
            case 1:
                pos = new int[]{1,1,2,2,0,0,5,5,6,6,4,4};
                break;
            case 2:
                pos = new int[]{13,10,9,10,11,8,13,11,9,8};
                break;
            case 3:
                pos = new int[]{12,0,5,7,12,7,5,6,0,6,10,10};
                break;
            case 4:
                pos = new int[]{4,4,5,6,6,5,9,7,8,9,8,7};
                break;
        }
    }

    //Thoi gian dem nguoc
    @Override
    protected void onStart() {
        super.onStart();
        timer = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                thoiGian.setText("Time: " + String .valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                thoiGian.setText("Time: 0");
                Intent intent = new Intent(Round2Activity.this, HD3Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                int diemKQ = Integer.parseInt(diem.getText().toString());
                intent.putExtra("diem2_1", diemKQ);
                startActivity(intent);
                finish();
            }
        }.start();
    }

    private void checkEnd() {
        AlertDialog.Builder alerdialogbuilder = new AlertDialog.Builder(Round2Activity.this);
        alerdialogbuilder.setMessage("SCORE: " + score).setCancelable(false)
                .setPositiveButton("Continute", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), HD3Activity.class);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        AlertDialog alertDialog = alerdialogbuilder.create();
        alertDialog.show();
        //byExtras();
    }

    public void byExtras(){
        Intent intent = new Intent(Round2Activity.this, ThongBaoActivity.class);
        intent.putExtra(truyenDiem, diem.getText().toString());
        startActivity(intent);
    }

}
