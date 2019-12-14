package com.example.timerapp20;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;

public class OneTimer extends AppCompatActivity {
    private static final long START_TIME = 60000;




   // private ProgressBar pgBar;
   // private ProgressBar pgBar2;
    //Timer 1
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mOkayBtn;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeft;

    //SetTimerAttributes
    private String sTimer1Name;
    private int iTime1;
    private int i = 0;
    private TextView tName1;
    private MediaPlayer alarmSoundMp;
   // private Button setButton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_timer);
        alarmSoundMp = MediaPlayer.create(this, R.raw.alarm3);

       // pgBar = (ProgressBar) findViewById(R.id.progressBar);
       // pgBar2 = (ProgressBar) findViewById(R.id.progressBar2);


        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.buton_start_pause);

        Intent iOneTimer2 = getIntent();
        sTimer1Name = iOneTimer2.getStringExtra(CreateTimerOne.EXTRA_TEXT);
        iTime1 = iOneTimer2.getIntExtra(CreateTimerOne.EXTRA_NUMBER, 0);

        tName1 = (TextView)findViewById(R.id.textView);
        sTimer1Name.toUpperCase();
        tName1.setText(sTimer1Name);
        mTimeLeft = (int)iTime1 * 60000;

        updateCountDownText();

        mOkayBtn = (Button)findViewById(R.id.okbutton);
        mOkayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmSoundMp.stop();
                mOkayBtn.setVisibility(View.INVISIBLE);
                tName1.setVisibility(View.INVISIBLE);
            }
        });


        //Timer 1

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pgBar.setProgress(100);
                if(mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });
        updateCountDownText();

    }
    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeft, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeft = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                alarmSoundMp.start();
                mTextViewCountDown.setText("00:00");
                tName1.setText(sTimer1Name + " is ready!");
                mTimerRunning = false;
                mOkayBtn.setVisibility(View.VISIBLE);
                mTextViewCountDown.setVisibility(View.INVISIBLE);
                mButtonStartPause.setVisibility(View.INVISIBLE);
            }
        }.start();
        mTimerRunning = true;
        mButtonStartPause.setText("pause");
    }
    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
    }
    private void updateCountDownText(){
        int minutes = (int)mTimeLeft / 1000 / 60;
        int seconds = (int)mTimeLeft / 1000 % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }

}
