package com.example.naochiennhom2;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Round1Activity extends AppCompatActivity {
    int a, b;
    ArrayList<CauHoi> data;
    CountDownTimer timer;
    Button btnA, btnB, btnC, btnD;
    TextView txtCauHoi, txtThoiGian, txtDiem;
    int diem = 0;
    int nKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round1);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setCauHoi();
        setControl();
        setEvent();
    }

    private void setControl() {
        txtCauHoi = (TextView)findViewById(R.id.txtcauhoi);
        btnA = (Button)findViewById(R.id.a);
        btnB = (Button)findViewById(R.id.b);
        btnC = (Button)findViewById(R.id.c);
        btnD = (Button)findViewById(R.id.d);
        txtThoiGian = (TextView)findViewById(R.id.txttime);
        txtDiem = (TextView)findViewById(R.id.txtdiem);

    }
    private void setEvent() {
        //Random câu hỏi
        a = 0 + (int) (Math.random() * ((data.size() - 1 ) + 1));
        //Random câu trả lời
        b = 0 + (int) (Math.random() * ((3 - 0) + 1));

        nKQ = 0;
        switch (a) {
            case 0:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 1:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 2:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 3:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 4:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 5:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 6:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 7:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 8:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 9:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 10:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 11:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 12:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 13:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
            case 14:
                txtCauHoi.setText(data.get(a).getCauHoi());
                break;
        }
        switch (b) {
            case 0:
                btnA.setText(data.get(a).getCauTL1());
                btnB.setText(data.get(a).getCauTL2());
                btnC.setText(data.get(a).getCauTL3());
                btnD.setText(data.get(a).getCauTL4());

                btnA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnA.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnB.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnC.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnD.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                break;
            case 1:
                btnA.setText(data.get(a).getCauTL1());
                btnB.setText(data.get(a).getCauTL2());
                btnC.setText(data.get(a).getCauTL3());
                btnD.setText(data.get(a).getCauTL4());

                btnA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnA.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnB.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnC.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnD.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                break;
            case 2:
                btnA.setText(data.get(a).getCauTL1());
                btnB.setText(data.get(a).getCauTL2());
                btnC.setText(data.get(a).getCauTL3());
                btnD.setText(data.get(a).getCauTL4());

                btnA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnA.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnB.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnC.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnD.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                break;
            case 3:
                btnA.setText(data.get(a).getCauTL1());
                btnB.setText(data.get(a).getCauTL2());
                btnC.setText(data.get(a).getCauTL3());
                btnD.setText(data.get(a).getCauTL4());

                btnA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnA.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnB.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnC.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                btnD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (btnD.getText() == data.get(a).getDapAn()) {
                            Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem += 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_SHORT).show();
                            diem = Integer.parseInt(txtDiem.getText().toString());
                            diem -= 10;
                            txtDiem.setText(String.valueOf(diem));
                            setEvent();
                        }
                    }
                });
                break;
        }

    }

    // Đếm ngược thời gian
    @Override
    protected void onStart() {
        super.onStart();
        timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtThoiGian.setText("Time: " + String .valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                txtThoiGian.setText("Time: 0");
                Intent intent = new Intent(Round1Activity.this, HD2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                int diemKQ = Integer.parseInt(txtDiem.getText().toString());
                intent.putExtra("diem", diemKQ);
                startActivity(intent);
            }
        }.start();
    }

    // Tạo câu hỏi
    private void setCauHoi() {
        data = new ArrayList<>();
        data.add(new CauHoi("113 * 3 = ", "339", "515", "225", "333", "339"));
        data.add(new CauHoi("369 / 3 = ", "321", "123", "132", "111", "123"));
        data.add(new CauHoi("53 * 5 = ", "185", "250", "265", "305", "265"));
        data.add(new CauHoi("440 / 4 = ", "100", "101", "110", "111", "110"));
        data.add(new CauHoi("84 / 6 = ", "14", "11", "15", "19", "14"));
        data.add(new CauHoi("1 + 1 = ", "1", "2", "3", "4", "2"));
        data.add(new CauHoi("5 + 4 = ", "6", "11", "9", "10", "9"));
        data.add(new CauHoi("6 + 2 = ", "12", "8", "7", "5", "8"));
        data.add(new CauHoi("6 - 2 = ", "4", "8", "7", "5", "4"));
        data.add(new CauHoi("12 - 5 = ", "12", "8", "7", "5", "7"));
        data.add(new CauHoi("18 - 7 = ", "12", "11", "7", "5", "11"));
        data.add(new CauHoi("3 * 3 = ", "12", "8", "7", "9", "9"));
        data.add(new CauHoi("3 * 5 = ", "12", "8", "15", "11", "15"));
        data.add(new CauHoi("7 * 2 = ", "12", "11", "15", "14", "14"));
        data.add(new CauHoi("8 / 2 = ", "5", "3", "4", "6", "4"));

    }

}
