package com.example.naochiennhom2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class MemoryActivity extends AppCompatActivity {

    TextView p1, p2;
    ImageView iv11, iv12, iv13, iv14, iv21, iv22, iv23, iv24, iv31, iv32, iv33, iv34;
    Integer[] cardArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};
    int img101, img102, img103, img104, img105, img106,
            img201, img202, img203, img204, img205, img206;
    int firstCard, secondCard, click1, click2;
    int cardNumber = 1;
    int turn = 1;
    int player1 = 0, player2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        setControl();
        setEvent();

    }

    private void setEvent() {
        iv11.setTag("0");
        iv12.setTag("1");
        iv13.setTag("2");
//        iv14.setTag("3");
        iv21.setTag("3");
        iv22.setTag("4");
        iv23.setTag("5");
//        iv24.setTag("7");
//        iv31.setTag("8");
//        iv32.setTag("9");
//        iv33.setTag("10");
//        iv34.setTag("11");
        cardResource();
        //shuffle the img
        Collections.shuffle(Arrays.asList(cardArray));
        //klq
        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv11,theCard);
            }
        });
        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv12,theCard);
            }
        });
        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv13,theCard);
            }
        });
        iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv21,theCard);
            }
        });
        iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv22,theCard);
            }
        });
        iv23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv23,theCard);
            }
        });

    }

    private void  doStuff(ImageView iv, int card){

        if(cardArray[card] == 101){
            iv.setImageResource(img101);
        } else if (cardArray[card] == 102){
            iv.setImageResource(img102);
        }
        else if (cardArray[card] == 103){
            iv.setImageResource(img103);
        }
        else if (cardArray[card] == 201){
            iv.setImageResource(img201);
        } else if (cardArray[card] == 202){
            iv.setImageResource(img202);
        }
        else if (cardArray[card] == 203){
            iv.setImageResource(img203);
        }
        //Kiem tra anh duoc chon va luu
        if(cardNumber == 1){
            firstCard = cardArray[card];
            if(firstCard > 200){
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            click1 = card;
            iv.setEnabled(false);
        } else if (cardNumber == 2){
            secondCard = cardArray[card];
            if(secondCard > 200){
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            click2 = card;
            iv11.setEnabled(false);
            iv12.setEnabled(false);
            iv13.setEnabled(false);
            iv21.setEnabled(false);
            iv22.setEnabled(false);
            iv23.setEnabled(false);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    caculate();
                }
            }, 1000);
        }
    }

    private  void caculate(){
        if(firstCard == secondCard){
            if(click1 == 0){
                iv11.setVisibility(View.INVISIBLE);
            } else if(click1 == 1){
                iv12.setVisibility(View.INVISIBLE);
            } else if(click1 == 2){
                iv13.setVisibility(View.INVISIBLE);
            } else if(click1 == 3){
                iv21.setVisibility(View.INVISIBLE);
            } else if(click1 == 4){
                iv22.setVisibility(View.INVISIBLE);
            } else if(click1 == 5){
                iv23.setVisibility(View.INVISIBLE);
            }

            if(click2 == 0){
                iv11.setVisibility(View.INVISIBLE);
            } else if(click2 == 1){
                iv12.setVisibility(View.INVISIBLE);
            } else if(click2 == 2){
                iv13.setVisibility(View.INVISIBLE);
            } else if(click2 == 3){
                iv21.setVisibility(View.INVISIBLE);
            } else if(click2 == 4){
                iv22.setVisibility(View.INVISIBLE);
            } else if(click2 == 5){
                iv23.setVisibility(View.INVISIBLE);
            }

            if(turn == 1){
                player1++;
                p1.setText("p1:" + player1);
            } else if(turn == 2){
                player2++;
                p1.setText("p2:" + player2);
            }
        } else {
            iv11.setImageResource(R.drawable.brain_data);
            iv12.setImageResource(R.drawable.brain_data);
            iv13.setImageResource(R.drawable.brain_data);
            iv21.setImageResource(R.drawable.brain_data);
            iv22.setImageResource(R.drawable.brain_data);
            iv23.setImageResource(R.drawable.brain_data);

            if(turn == 1){
                turn = 2;
            } else if (turn == 2){
                turn = 1;
            }
        }
        iv11.setEnabled(true);
        iv12.setEnabled(true);
        iv13.setEnabled(true);
        iv21.setEnabled(true);
        iv22.setEnabled(true);
        iv23.setEnabled(true);

        checkEnd();
    }

    private void checkEnd(){
        if(iv11.getVisibility() == View.INVISIBLE && iv12.getVisibility() == View.INVISIBLE && iv13.getVisibility() == View.INVISIBLE
                && iv21.getVisibility() == View.INVISIBLE && iv22.getVisibility() == View.INVISIBLE && iv23.getVisibility() == View.INVISIBLE){
            AlertDialog.Builder alerdialogbuilder = new AlertDialog.Builder(MemoryActivity.this);
            alerdialogbuilder.setMessage("Game over\np1:" + player1 + "\np2:" +  player2).setCancelable(false)
            .setPositiveButton("New", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MemoryActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog = alerdialogbuilder.create();
            alertDialog.show();
        }
    }

    private void setControl() {
        p1 = (TextView)findViewById(R.id.p1);
        p2 = (TextView)findViewById(R.id.p2);
        iv11 = (ImageView)findViewById(R.id.iv11);
        iv12 = (ImageView)findViewById(R.id.iv12);
        iv13 = (ImageView)findViewById(R.id.iv13);
//        iv14 = (ImageView)findViewById(R.id.iv14);
        iv21 = (ImageView)findViewById(R.id.iv21);
        iv22 = (ImageView)findViewById(R.id.iv22);
        iv23 = (ImageView)findViewById(R.id.iv23);
//        iv24 = (ImageView)findViewById(R.id.iv24);
//        iv31 = (ImageView)findViewById(R.id.iv31);
//        iv32 = (ImageView)findViewById(R.id.iv32);
//        iv33 = (ImageView)findViewById(R.id.iv33);
//        iv34 = (ImageView)findViewById(R.id.iv34);
    }
    private void cardResource(){
        img101 = R.drawable.a;
        img102 = R.drawable.b;
        img103 = R.drawable.c;

    }
}
