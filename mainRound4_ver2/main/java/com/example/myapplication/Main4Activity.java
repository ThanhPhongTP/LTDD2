package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    Button btnSo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btnSo2 = (Button)findViewById(R.id.btnSo2);

        btnSo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Đúng rồi", Toast.LENGTH_LONG).show();
                final  Intent intent = new Intent(getApplicationContext(),Main5Activity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                startActivity(intent);
                Thread timer = new Thread() {
                    public void run() {
                        try {
                            sleep(1000);
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
        });
    }
}
