package com.example.naochiennhom2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Round4_lv1Activity extends AppCompatActivity {
    private ImageView img1, img2, img3, img4;
    private LinearLayout layout1, layout2;
    private LinearLayout layout4, layout3;
    private int soAnh1 = 0, soAnh2 = 0;


    CountDownTimer demthoigian;
    TextView txtDiem, txtThoiGian;
    int tongdiemcu, tongdiemmoi, diemcong;
    SharedPreferences luutru;

    private Dialog dialog;
    private Button btnLogout;

    SharedPreferences luuTru;



    View.OnDragListener dang1 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            switch (dragEvent.getAction()) {
                case DragEvent.ACTION_DROP:
                    View con = (View) dragEvent.getLocalState();
                    ViewGroup chaRuot = (ViewGroup) con.getParent();
                    LinearLayout chaNuoi = (LinearLayout) view;
                    if (check1(chaNuoi.getId())) {
                        chaRuot.removeView(con);
                        chaNuoi.addView(con);
                        con.setVisibility(View.VISIBLE);
                        checkID2(chaRuot.getId());
                        if (checkWin()) {
                            Toast.makeText(getApplicationContext(), "you win", Toast.LENGTH_SHORT).show();
                            demthoigian.cancel();
                            LuuDuLieuNguoiDung(diemcong);
                            txtDiem.setText(String.valueOf(tongdiemmoi));
                            youWin();
                        }
                    } else {

                    }
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        setConTrol();
        setEvent();

    }

    private void checkID2(int id) {
        switch (id) {
            case R.id.layout1:
                if (soAnh1 > 0) {
                    soAnh1--;
                }
                break;
            case R.id.layout2:
                if (soAnh2 > 0) {
                    soAnh2--;
                }
                break;
        }
    }

    private boolean check1(int id) {
        if (id == R.id.layout1) {
            if (soAnh1 == 2) {
                return false;
            } else {
                soAnh1++;
                return true;
            }
        } else if (id == R.id.layout2) {
            if (soAnh2 == 2) {
                return false;
            } else {
                soAnh2++;
                return true;
            }
        } else if (id == R.id.layou3 || id == R.id.layou4 ) {
            return true;
        } else {
            return false;
        }
    }

    private void setConTrol() {
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);



        layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (LinearLayout) findViewById(R.id.layout2);




        layout3 = (LinearLayout) findViewById(R.id.layou3);
        layout4 = (LinearLayout) findViewById(R.id.layou4);



        txtDiem = (TextView) findViewById(R.id.txtDiem);
        txtThoiGian = (TextView) findViewById(R.id.txtThoiGian);
        Bundle mydata = getIntent().getExtras();
        int diemKQ = mydata.getInt("diem3_1");
        txtDiem.setText(String.valueOf(diemKQ));
    }

    private void setEvent() {
        layout1.setOnDragListener(dang1);
        layout2.setOnDragListener(dang1);
        layout3.setOnDragListener(dang1);
        layout4.setOnDragListener(dang1);


        luuTru = getSharedPreferences("luutruthongtin", Context.MODE_PRIVATE);
        tongdiemcu = luuTru.getInt("TongDiem", 0);
        txtDiem.setText(String.valueOf(tongdiemcu));


        img1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                View.DragShadowBuilder dang2 = new View.DragShadowBuilder(view);
                view.startDrag(null, dang2, view, 0);
                return true;
            }
        });
        img2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                View.DragShadowBuilder dang2 = new View.DragShadowBuilder(view);
                view.startDrag(null, dang2, view, 0);
                return true;
            }
        });
        img3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                View.DragShadowBuilder dang2 = new View.DragShadowBuilder(view);
                view.startDrag(null, dang2, view, 0);
                return true;
            }
        });
        img4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                View.DragShadowBuilder dang2 = new View.DragShadowBuilder(view);
                view.startDrag(null, dang2, view, 0);
                return true;
            }
        });


//
        demthoigian = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long milis = millisUntilFinished;
                //long gio = TimeUnit.MILLISECONDS.toHours(milis);
                //long phut = TimeUnit.MILLISECONDS.toMinutes(milis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milis));
                long giay = TimeUnit.MILLISECONDS.toSeconds(milis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milis));

               // String giophutgiay = String.format("%02d:%02d:%02d", gio, phut, giay);
                String sgiay = String.format("%02d", giay);
                txtThoiGian.setText(sgiay);
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_LONG).show();
                Editor edit = luuTru.edit();
                tongdiemcu = luuTru.getInt("TongDiem", 1000);
                tongdiemmoi = tongdiemcu - 100;
                edit.putInt("TongDiem", tongdiemmoi);
                edit.commit();

                txtDiem.setText(String.valueOf(tongdiemmoi));
                demthoigian.cancel();
                gameOver();

            }
        };
        demthoigian.start();
    }
    private  void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("You lose");
        alertDialogBuilder.setIcon(R.drawable.iconcuoi);

        alertDialogBuilder.setPositiveButton("Chơi lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(Round4_lv1Activity.this, Round4_lv2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                int diemKQ = Integer.parseInt(txtDiem.getText().toString());
                intent.putExtra("diem4", diemKQ);
                startActivity(intent);
                arg0.dismiss();

            }
        });

        alertDialogBuilder.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void ramdomImage(){


    }

        public void youWin() {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("You win");
            alertDialogBuilder.setIcon(R.drawable.iconcuoi);

            alertDialogBuilder.setPositiveButton("Tiếp tục", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    final Intent intent = new Intent(Round4_lv1Activity.this, Round4_lv2Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    int diemKQ = Integer.parseInt(txtDiem.getText().toString());
                    intent.putExtra("diem4", diemKQ);
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

    private void LuuDuLieuNguoiDung(int diemcong) {
        Editor edit = luuTru.edit();
        tongdiemcu = luuTru.getInt("TongDiem", 1000);
        tongdiemmoi = tongdiemcu + 100;
        edit.putInt("TongDiem", tongdiemmoi);
        edit.commit();
    }

    private boolean checkWin() {
        int check = 0;
        if (soAnh1 == 2) {
            if (R.id.img1 == layout1.getChildAt(0).getId()
                && R.id.img2 == layout1.getChildAt(1).getId())
            {
                check++;

            } else {

            }
        }
        if (soAnh2 == 2) {
            if (R.id.img3 == layout2.getChildAt(0).getId()
                && R.id.img4 == layout2.getChildAt(1).getId())
            {
                check++;
            } else {

            }
        }
        if (check == 2) {
            return true;
        } else {
            return false;
        }
    }

}
