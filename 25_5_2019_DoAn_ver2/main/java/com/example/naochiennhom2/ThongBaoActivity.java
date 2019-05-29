package com.example.naochiennhom2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ThongBaoActivity extends AppCompatActivity {
    ListView lvStopScore;
    TextView tvDiem;
    Button Exit;
    ArrayAdapter adapter;
    ArrayList<String> diemList;
    int diemKQ, tongDiem;
    SharedPreferences luuTru;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);
        setControl();
        setEvent();
    }

    private void setEvent() {
        diemList.add(String.valueOf(tongDiem));
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, diemList);
        lvStopScore.setAdapter(adapter);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThongBaoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        tvDiem = (TextView)findViewById(R.id.tvdiem);
        lvStopScore = (ListView) findViewById(R.id.lvStopScore);
        Exit = (Button) findViewById(R.id.btnExit);
        diemList = new ArrayList<>();
        Bundle mydata = getIntent().getExtras();
        diemKQ = mydata.getInt("diem4");
        luuTru = getSharedPreferences("luutruthongtin", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = luuTru.edit();
        tongDiem = luuTru.getInt("TongDiem", diemKQ);
        edit.putInt("TongDiem", tongDiem);
        edit.commit();
    }


}
