package com.example.timerapp20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateTimerOne extends AppCompatActivity {
    Intent iOneTimer2;

    public static final String EXTRA_TEXT = "com.example.timerapp20.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "com.example.timerapp20.EXTRA_NUMBER";

    private String sTimerName;
    private int iTimerMins;
    private Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_timer_one);

        iOneTimer2 = new Intent(getApplicationContext(), OneTimer.class);

        nextButton = findViewById(R.id.nxtButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }
    public void openActivity2(){

        EditText timerName = (EditText) findViewById(R.id.editTimerName);
        EditText timerTime = (EditText) findViewById(R.id.editTime);
        sTimerName = timerName.getText().toString();

        iTimerMins = Integer.parseInt(timerTime.getText().toString());


        iOneTimer2.putExtra(EXTRA_TEXT, sTimerName);
        iOneTimer2.putExtra(EXTRA_NUMBER, iTimerMins);
        startActivity(iOneTimer2);
    }
}
