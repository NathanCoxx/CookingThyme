package com.example.timerapp20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CreateTimerTwo extends AppCompatActivity {

    Intent iTimerTwo;
    Intent iPopup;

    public static final String EXTRA_NAME1 = "com.example.timerapp20.EXTRA_NAME1";
    public static final String EXTRA_TIME1 = "com.example.timerapp20.EXTRA_TIME1";
    public static final String EXTRA_NAME2 = "com.example.timerapp20.EXTRA_NAME2";
    public static final String EXTRA_TIME2 = "com.example.timerapp20.EXTRA_TIME2";

    private String name1;
    private String name2;
    private int time1;
    private int time2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_timer_two);

        iTimerTwo = new Intent(getApplicationContext(), TwoTimers.class);
        iPopup = new Intent(getApplicationContext(), PopActivity.class);
        startActivity(iPopup);

        Intent intentBack = getIntent();
        name1 = intentBack.getStringExtra(PopActivity.EXTRA_NAME);
        time1 = intentBack.getIntExtra(PopActivity.EXTRA_MINS, 0);

        startActivity(iPopup);
        intentBack = getIntent();
        name2 = intentBack.getStringExtra(PopActivity.EXTRA_NAME);
        time2 = intentBack.getIntExtra(PopActivity.EXTRA_MINS, 0);

        TextView tv = (TextView)findViewById(R.id.tv);
        tv.setText(name2);

        Button create = (Button)findViewById(R.id.createBtn);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTimerTwo.putExtra(EXTRA_NAME1, name1);
                iTimerTwo.putExtra(EXTRA_TIME1, time1);
                iTimerTwo.putExtra(EXTRA_NAME2, name2);
                iTimerTwo.putExtra(EXTRA_TIME2, time2);
                startActivity(iTimerTwo);
            }
        });

        startActivity(iTimerTwo);


    }
}
