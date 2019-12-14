package com.example.timerapp20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent iOneTimer;
    Intent iCreateTwoTimers;
    Intent iThreeTimers;
    Intent iFourTimers;
    Intent iCANTimers;
    Intent iCommonTimes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iOneTimer = new Intent(getApplicationContext(), CreateTimerOne.class);
        iCreateTwoTimers = new Intent(getApplicationContext(), TwoTimers.class);
        iThreeTimers = new Intent(getApplicationContext(), ThreeTimers.class);
        iFourTimers = new Intent(getApplicationContext(), FourTimers.class);
        iCANTimers = new Intent(getApplicationContext(), CANTimers.class);
        iCommonTimes = new Intent(getApplicationContext(), CommonTimes.class);

        Button timer1 = (Button)findViewById(R.id.oneBtn);
        timer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iOneTimer);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        Button timer2 = (Button)findViewById(R.id.twoBtn);
        timer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iCreateTwoTimers);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);           }
        });
        Button timer3 = (Button)findViewById(R.id.threeBtn);
        timer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iThreeTimers);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);            }
        });
        Button canBtn = (Button)findViewById(R.id.bCanTimers);
        canBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iCANTimers);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);            }
        });
        Button timer4 = (Button)findViewById(R.id.fourTimersBtn);
        timer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iFourTimers);
            }
        });
        Button bCommonTimes = (Button)findViewById(R.id.commonBtn);
        bCommonTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iCommonTimes);
                overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
            }
        });


    }
}
