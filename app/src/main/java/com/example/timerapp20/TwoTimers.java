package com.example.timerapp20;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class TwoTimers extends AppCompatActivity {
    private static final long START_TIME = 60000;
    public static final String EXTRA_TITLE1 = "com.example.timerapp20.EXTRA_TITLE1";
    public static final String EXTRA_TITLE2 = "com.example.timerapp20.EXTRA_TITLE2";

    Intent popUp2;
    Intent popUp3;
    Intent backToMain;
    private MediaPlayer alarmSoundMp;
    private MediaPlayer alarmSoundMp2;
    //Timer 1
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button okayButton1;
    private Button okayButton2;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeft;

    //Timer 2
    private TextView mTextViewCountDown2;
    private Button mButtonStartPause2;
    private Button cancelButton;
    private CountDownTimer mCountDownTimer2;
    private boolean mTimer2Running;
    private long mTimer2MinsLeft;

    //SetTimerAttributes
    private int iTime1;
    private int iTime2;
    private String sTimer1Name;
    private String sTimer2Name;
    private TextView tName1;
    private TextView tName2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_timers);

        alarmSoundMp = MediaPlayer.create(this, R.raw.alarm3);
        alarmSoundMp2 = MediaPlayer.create(this, R.raw.alarm3);
        backToMain = new Intent(getApplicationContext(), MainActivity.class);
        cancelButton = (Button)findViewById(R.id.cancelBtn);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(backToMain);
                alarmSoundMp.stop();
                alarmSoundMp2.stop();
            }
        });

        tName1 = (TextView)findViewById(R.id.tvTimer1);
        tName2 = (TextView)findViewById(R.id.tvTimer2);

        popUp2 = new Intent(this, PopActivity.class);
        popUp2.putExtra(EXTRA_TITLE1, "TIMER 2");
        startActivityForResult(popUp2, 1);

        popUp3 = new Intent(this, PopActivity.class);
        popUp3.putExtra(EXTRA_TITLE1, "TIMER 1");
        startActivityForResult(popUp3, 2);




        //Timer 1
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.buton_start_pause);
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });
        updateCountDownText();
        //TImer 2
        mTextViewCountDown2 = findViewById(R.id.text_view_countdown2);
        mButtonStartPause2 = findViewById(R.id.buton_start_pause2);
        mButtonStartPause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimer2Running){
                    pauseTimer2();
                }
                else{
                    startTimer2();
                }
            }
        });
        updateCountDownText2();

        //After Timer finished
        okayButton1 = findViewById(R.id.okayBtn1);
        okayButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmSoundMp2.stop();
                okayButton1.setVisibility(View.INVISIBLE);
                tName2.setVisibility(View.INVISIBLE);
            }
        });
        okayButton2 = findViewById(R.id.okayBtn2);
        okayButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmSoundMp.stop();
                okayButton2.setVisibility(View.INVISIBLE);
                tName1.setVisibility(View.INVISIBLE);
            }
        });
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
                mTimerRunning = false;
                mTextViewCountDown.setText("00:00");
                tName1.setText(sTimer1Name + " is ready!");
                okayButton2.setVisibility(View.VISIBLE);
                mButtonStartPause.setText("Start");
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
    //Timer 2
    private void startTimer2(){
        mCountDownTimer2 = new CountDownTimer(mTimer2MinsLeft, 1000) {
            @Override
            public void onTick(long l) {
                mTimer2MinsLeft = l;
                updateCountDownText2();
            }

            @Override
            public void onFinish() {
                alarmSoundMp2.start();
                mTimer2Running = false;
                tName2.setText(sTimer2Name + " is ready!");
                mButtonStartPause2.setText("Start");
                mTextViewCountDown2.setText("00:00");
                okayButton1.setVisibility(View.VISIBLE);
                mButtonStartPause2.setVisibility(View.INVISIBLE);
            }
        }.start();
        mTimer2Running = true;
        mButtonStartPause2.setText("pause");
    }
    private void pauseTimer2() {
        mCountDownTimer2.cancel();
        mTimer2Running = false;
        mButtonStartPause2.setText("Start");
    }
    private void updateCountDownText2(){
        int minutes = (int)mTimer2MinsLeft / 1000 / 60;
        int seconds = (int)mTimer2MinsLeft / 1000 % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown2.setText(timeLeftFormatted);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                sTimer1Name=data.getStringExtra("name");
                int iTime1 = data.getIntExtra("time", 0);
                tName1.setText(sTimer1Name);
                mTimeLeft = (int)iTime1 * 60000;
                updateCountDownText();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                tName1.setText("No Data Retreived");
            }
        }
        if(requestCode == 2){
            if(resultCode == Activity.RESULT_OK){
                sTimer2Name=data.getStringExtra("name");
                int iTime2 = data.getIntExtra("time", 0);
                tName2.setText(sTimer2Name);
                mTimer2MinsLeft = (int)iTime2 * 60000;
                updateCountDownText2();

                mTextViewCountDown.setVisibility(View.VISIBLE);
                mTextViewCountDown2.setVisibility(View.VISIBLE);
                mButtonStartPause.setVisibility(View.VISIBLE);
                mButtonStartPause2.setVisibility(View.VISIBLE);
                cancelButton.setVisibility(View.VISIBLE);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                tName1.setText("No Data Retreived");
            }
        }
    }
}

