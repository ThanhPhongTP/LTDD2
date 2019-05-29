package com.example.naochiennhom2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnPlay, btnAbout;
    ImageView imgSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setControl();
        setEvent();
    }

    private void setControl() {
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnAbout = (Button)findViewById(R.id.about);
        imgSetting = (ImageView)findViewById(R.id.setting);
    }
    private void setEvent(){
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HD1Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAbout();
            }
        });
        imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }



    public void showAbout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GAME NÃO CHIẾN (Vertion 1.0)");
        builder.setMessage("Não chiến là thể loại game thuộc thể loại về trí tuệ, game này được tạo ra bởi các thành viên đẹp trai trong nhóm 2 gồm: Phong, Nhân, An, Chiến");
        builder.setCancelable(false);
        builder.setNegativeButton("Quay lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
