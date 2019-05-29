package com.example.naochiennhom2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.*;

import java.util.Random;

public class Round3Activity extends AppCompatActivity {
    TextView tvDiem, thoiGian;
    Button Mau1, Mau2, Mau3, Mau4, Mau5, Mau6,  Mau7, Mau8;
    Random randomMau, randomMauSai, randomText;
    Integer[] arrMaMau = {R.color.red, R.color.green, R.color.yellow, R.color.blue, R.color.orange, R.color.violet};
    String[] arrRed = {"Green", "Yellow", "Blue", "Orange", "Violet"};
    String[] arrYellow = {"Green", "Red", "Blue", "Orange", "Violet"};
    String[] arrGreen = {"Red", "Yellow", "Blue", "Orange", "Violet"};
    String[] arrBlue = {"Green", "Yellow", "Red", "Orange", "Violet"};
    String[] arrOrange = {"Green", "Yellow", "Blue", "Red", "Violet"};
    String[] arrViolet = {"Green", "Yellow", "Blue", "Orange", "Red"};
    int dem;
    SharedPreferences luuTru;
    Handler handler;
    CountDownTimer timer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round3);
        //final Intent intent = new Intent(this,Main7Activity.class);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setConTrol();
        setEvent();
        onStart();

    }

    private void setEvent() {
        if(dem < 5){
            RandomMau(Mau1);
            RandomMau(Mau2);
            RandomMau(Mau4);
            RandomMau(Mau5);
            RandomMauSai_4_Button(Mau1, Mau2, Mau4, Mau5);
        }else if(dem < 10){
            RandomMau(Mau1);
            RandomMau(Mau2);
            RandomMau(Mau4);
            RandomMau(Mau5);
            RandomMau(Mau7);
            RandomMau(Mau8);
            RandomMauSai_6_Button(Mau1, Mau2, Mau4, Mau5, Mau7, Mau8);
        }
        else{
            RandomMau(Mau1);
            RandomMau(Mau2);
            RandomMau(Mau3);
            RandomMau(Mau4);
            RandomMau(Mau5);
            RandomMau(Mau6);
            RandomMau(Mau7);
            RandomMau(Mau8);
            RandomMauSai_8_Button(Mau1, Mau2, Mau3, Mau4, Mau5, Mau6, Mau7, Mau8);
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
                Intent intent = new Intent(Round3Activity.this, Round4Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                int diemKQ = Integer.parseInt(tvDiem.getText().toString());
                intent.putExtra("diem3_1", diemKQ);
                startActivity(intent);
            }
        }.start();
    }

    private void setConTrol() {
        Mau1 = (Button) findViewById(R.id.btnMau1);
        Mau2 = (Button) findViewById(R.id.btnMau2);
        Mau3 = (Button) findViewById(R.id.btnMau3);
        Mau4 = (Button) findViewById(R.id.btnMau4);
        Mau5 = (Button) findViewById(R.id.btnMau5);
        Mau6 = (Button) findViewById(R.id.btnMau6);
        Mau7 = (Button) findViewById(R.id.btnMau7);
        Mau8 = (Button) findViewById(R.id.btnMau8);
        tvDiem = (TextView) findViewById(R.id.txtDiem);
        thoiGian = (TextView) findViewById(R.id.txtThoiGian);
        Bundle mydata = getIntent().getExtras();
        int diemKQ = mydata.getInt("diem3");
        tvDiem.setText(String.valueOf(diemKQ));
    }
    // set thời gian qua màng
    private void setTimeOut(final Intent intent) {
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }

            }
        };
        timer.start();
    }
    //set mau SAI 4 button
    private void RandomMauSai_4_Button(Button btn1, Button btn2, Button btn3, Button btn4){
        randomMauSai = new Random();
        int rd =  randomMauSai.nextInt(4);
        switch (rd)
        {
            case 0:
                setTextMauSai(btn1);
                chooseRight(btn1);
                break;
            case 1:
                setTextMauSai(btn2);
                chooseRight(btn2);
                break;
            case 2:
                setTextMauSai(btn3);
                chooseRight(btn3);
                break;
            case 3:
                setTextMauSai(btn4);
                chooseRight(btn4);
                break;
        }
    }
    // set mau SAI 6 button
    private void RandomMauSai_6_Button(Button btn1, Button btn2, Button btn3, Button btn4, Button btn5, Button btn6){
        randomMauSai = new Random();
        int rd =  randomMauSai.nextInt(6);
        switch (rd)
        {
            case 0:
                setTextMauSai(btn1);
                chooseRight(btn1);
                break;
            case 1:
                setTextMauSai(btn2);
                chooseRight(btn2);
                break;
            case 2:
                setTextMauSai(btn3);
                chooseRight(btn3);
                break;
            case 3:
                setTextMauSai(btn4);
                chooseRight(btn4);
                break;
            case 4:
                setTextMauSai(btn5);
                chooseRight(btn5);
                break;
            case 5:
                setTextMauSai(btn6);
                chooseRight(btn6);
                break;
        }
    }
    // set mau SAI 8 button
    private void RandomMauSai_8_Button(Button btn1, Button btn2, Button btn3, Button btn4, Button btn5, Button btn6, Button btn7, Button btn8){
        randomMauSai = new Random();
        int rd =  randomMauSai.nextInt(8);
        switch (rd)
        {
            case 0:
                setTextMauSai(btn1);
                chooseRight(btn1);
                break;
            case 1:
                setTextMauSai(btn2);
                chooseRight(btn2);
                break;
            case 2:
                setTextMauSai(btn3);
                chooseRight(btn3);
                break;
            case 3:
                setTextMauSai(btn4);
                chooseRight(btn4);
                break;
            case 4:
                setTextMauSai(btn5);
                chooseRight(btn5);
                break;
            case 5:
                setTextMauSai(btn6);
                chooseRight(btn6);
                break;
            case 6:
                setTextMauSai(btn7);
                chooseRight(btn7);
                break;
            case 7:
                setTextMauSai(btn8);
                chooseRight(btn8);
                break;
        }
    }

    //set màu
    private void RandomMau(Button btnDemo){
        randomMau = new Random();
        int rd = randomMau.nextInt(6);
        switch (rd)
        {
            case 0:
                btnDemo.setBackgroundColor(getResources().getColor(arrMaMau[0]));
                checkMau(arrMaMau[0], btnDemo);
                chooseWrong(btnDemo);
                break;
            case 1:
                btnDemo.setBackgroundColor(getResources().getColor(arrMaMau[1]));
                checkMau(arrMaMau[1], btnDemo);
                chooseWrong(btnDemo);
                break;
            case 2:
                btnDemo.setBackgroundColor(getResources().getColor(arrMaMau[2]));
                checkMau(arrMaMau[2], btnDemo);
                chooseWrong(btnDemo);
                break;
            case 3:
                btnDemo.setBackgroundColor(getResources().getColor(arrMaMau[3]));
                checkMau(arrMaMau[3], btnDemo);
                chooseWrong(btnDemo);
                break;
            case 4:
                btnDemo.setBackgroundColor(getResources().getColor(arrMaMau[4]));
                checkMau(arrMaMau[4], btnDemo);
                chooseWrong(btnDemo);
                break;
            case 5:
                btnDemo.setBackgroundColor(getResources().getColor(arrMaMau[5]));
                checkMau(arrMaMau[5], btnDemo);
                chooseWrong(btnDemo);
                break;
        }
    }
    //set Text Mau Sai
    private void setTextMauSai(Button demo){
        ColorDrawable buttonColor = (ColorDrawable) demo.getBackground();
        //red
        if(buttonColor.getColor() == getResources().getColor(arrMaMau[0]))
        {
            RandomText(demo, arrRed);
        }
        //green
        if(buttonColor.getColor() == getResources().getColor(arrMaMau[1]))
        {
            RandomText(demo, arrGreen);
        }
        //yellow
        if(buttonColor.getColor() == getResources().getColor(arrMaMau[2]))
        {
            RandomText(demo, arrYellow);
        }
        //blue
        if(buttonColor.getColor() == getResources().getColor(arrMaMau[3]))
        {
            RandomText(demo, arrBlue);
        }
        //orange
        if(buttonColor.getColor() == getResources().getColor(arrMaMau[4]))
        {
            RandomText(demo, arrOrange);
        }
        //violet
        if(buttonColor.getColor() == getResources().getColor(arrMaMau[5]))
        {
            RandomText(demo, arrViolet);
        }
    }
    //check Mau
    private void checkMau(int n, Button btnDemo)
    {
        if(n == R.color.red){
            btnDemo.setText("Red");
        }
        if(n == R.color.green){
            btnDemo.setText("Green");
        }
        if(n == R.color.yellow){
            btnDemo.setText("Yellow");
        }
        if(n == R.color.blue){
            btnDemo.setText("Blue");
        }
        if(n == R.color.orange){
            btnDemo.setText("Orange");
        }
        if(n == R.color.violet){
            btnDemo.setText("Violet");
        }
    }
    //Chọn đúng
    private void chooseRight(final Button btnDemo)
    {
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Bạn đã chọn đúng", Toast.LENGTH_SHORT).show();
                int diemThuong = Integer.parseInt(tvDiem.getText().toString());
                diemThuong += 10;
                tvDiem.setText(String.valueOf(diemThuong));
                dem++;
                setEvent();
            }
        });
    }
    //Chon sai
    private void chooseWrong(final Button btnDemo)
    {
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Bạn đã chọn sai", Toast.LENGTH_SHORT).show();
                int diemThuong = Integer.parseInt(tvDiem.getText().toString());
                diemThuong -= 10;
                tvDiem.setText(String.valueOf(diemThuong));
            }
        });
    }
    //Random Text
    private void RandomText(Button btnDemo, String[] arr){
        randomText = new Random();
        int rd = randomText.nextInt(5);
        switch (rd)
        {
            case 0:
                btnDemo.setText(arr[0]);
                break;
            case 1:
                btnDemo.setText(arr[1]);
                break;
            case 2:
                btnDemo.setText(arr[2]);
                break;
            case 3:
                btnDemo.setText(arr[3]);
                break;
            case 4:
                btnDemo.setText(arr[4]);
                break;
        }
    }
}
