package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.media.SoundPool;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main5Activity extends AppCompatActivity {
    private ImageView img1, img2, img3, img4, img5, img6, img44, img55, img11;
    private LinearLayout layout1, layout2, layout6;
    private LinearLayout layout4, layout3, layout5;
    private int soAnh1 = 0, soAnh2 = 0, soAnh3 = 0;

    Integer[] arrayImage = {};

    CountDownTimer demthoigian;
    TextView txtDiem, txtThoiGian;
    int tongdiemcu, tongdiemmoi, diemcong, id_amthanh;
    SharedPreferences luutru;

    private Dialog dialog;
    private Button btnLogout;

    SharedPreferences luuTru;
    SoundPool amThanhChonAnh = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);


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
//                            Intent intent = new Intent(Main5Activity.this, Main3Activity.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//                            startActivity(intent);
//                            final Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                            Thread timer = new Thread() {
//                                public void run() {
//                                    try {
//                                        sleep(1000);
//                                    } catch (InterruptedException e) {
//                                        e.printStackTrace();
//                                    }
//                                    finally {
//                                        startActivity(intent);
//                                        finish();
//                                    }
//
//                                }
//                            };
//                            timer.start();
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
            case R.id.layout5:
                if (soAnh3 > 0) {
                    soAnh3--;
                }
                break;
        }
    }

    private boolean check1(int id) {
        if (id == R.id.layout1) {
            if (soAnh1 == 3) {
                return false;
            } else {
                soAnh1++;
                return true;
            }
        } else if (id == R.id.layout2) {
            if (soAnh2 == 3) {
                return false;
            } else {
                soAnh2++;
                return true;
            }
        }else  if (id == R.id.layout5) {
            if (soAnh3 == 3) {
                return false;
            } else {
                soAnh3++;
                return true;
            }
        } else if (id == R.id.layou3 || id == R.id.layou4 || id == R.id.layou6) {
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
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);
        img44 = (ImageView) findViewById(R.id.img44);
        img55 = (ImageView) findViewById(R.id.img55);
        img11 = (ImageView) findViewById(R.id.img11);


        layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        layout5 = (LinearLayout) findViewById(R.id.layout5);



        layout3 = (LinearLayout) findViewById(R.id.layou3);
        layout4 = (LinearLayout) findViewById(R.id.layou4);
        layout6 = (LinearLayout) findViewById(R.id.layou6);


        txtDiem = (TextView) findViewById(R.id.txtDiem);
        txtThoiGian = (TextView) findViewById(R.id.txtThoiGian);

    }

    private void setEvent() {
        layout1.setOnDragListener(dang1);
        layout2.setOnDragListener(dang1);
        layout3.setOnDragListener(dang1);
        layout4.setOnDragListener(dang1);
        layout5.setOnDragListener(dang1);
        layout6.setOnDragListener(dang1);

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
        img5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                View.DragShadowBuilder dang2 = new View.DragShadowBuilder(view);
                view.startDrag(null, dang2, view, 0);
                return true;
            }
        });
        img6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                View.DragShadowBuilder dang2 = new View.DragShadowBuilder(view);
                view.startDrag(null, dang2, view, 0);
                return true;
            }
        });
        img44.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                View.DragShadowBuilder dang2 = new View.DragShadowBuilder(view);
                view.startDrag(null, dang2, view, 0);
                return true;
            }
        });
        img55.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                View.DragShadowBuilder dang2 = new View.DragShadowBuilder(view);
                view.startDrag(null, dang2, view, 0);
                return true;
            }
        });
        img11.setOnLongClickListener(new View.OnLongClickListener() {
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
                Intent intent = new Intent(Main5Activity.this, Round4.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
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
                    final Intent intent = new Intent(Main5Activity.this, Main3Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                }
            });

            alertDialogBuilder.setNegativeButton("Choi lai", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    final Intent intent = new Intent(Main5Activity.this, Round4.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
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
        if (soAnh1 == 3) {
            if (R.id.img1 == layout1.getChildAt(0).getId()
                && R.id.img2 == layout1.getChildAt(1).getId()
                && R.id.img5 == layout1.getChildAt(2).getId())
            {
                check++;

            } else {

            }
        }
        if (soAnh2 == 3) {
            if (R.id.img3 == layout2.getChildAt(0).getId()
                && R.id.img4 == layout2.getChildAt(1).getId()
                    && R.id.img6 == layout2.getChildAt(2).getId() )
            {
                check++;
            } else {

            }
        }
        if (soAnh3 == 3) {
            if (R.id.img11 == layout5.getChildAt(0).getId()
                    && R.id.img55 == layout5.getChildAt(1).getId()
                    && R.id.img44 == layout5.getChildAt(2).getId() )
            {
                check++;
            } else {

            }
        }
        if (check == 3) {
            return true;
        } else {
            return false;
        }
    }

}
