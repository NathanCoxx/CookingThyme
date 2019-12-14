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

public class ThreeTimers extends AppCompatActivity {

    private static final long START_TIME = 60000;
    public static final String EXTRA_TITLE1 = "com.example.timerapp20.EXTRA_TITLE1";
    public static final String EXTRA_TITLE2 = "com.example.timerapp20.EXTRA_TITLE2";
    public static final String EXTRA_TITLE3 = "com.example.timerapp20.EXTRA_TITLE3";

    Intent popUp1;
    Intent popUp2;
    Intent popUp3;
    Intent backToMain;
    //alarm sound
    private MediaPlayer alarmSoundMp;
    private MediaPlayer alarmSoundMp2;
    private MediaPlayer alarmSoundMp3;

    //alarm finish
    private Button okayButton;
    private Button okayButton2;
    private Button okayButton3;

    //Timer 1
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeft;

    //Timer 2
    private TextView mTextViewCountDown2;
    private Button mButtonStartPause2;
    private CountDownTimer mCountDownTimer2;
    private boolean mTimer2Running;
    private long mTimer2MinsLeft;

    //Timer 3
    private TextView mTextViewCountDown3;
    private Button mButtonStartPause3;
    private Button cancelButton;
    private CountDownTimer mCountDownTimer3;
    private boolean mTimer3Running;
    private long mTimer3MinsLeft;

    //SetTimerAttributes
    private int iTime1;
    private int iTime2;
    private int iTime3;
    private String sTimer1Name;
    private String sTimer2Name;
    private String sTimer3Name;
    private TextView tName1;
    private TextView tName2;
    private TextView tName3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_timers);

        alarmSoundMp = MediaPlayer.create(this, R.raw.alarm3);
        alarmSoundMp2 = MediaPlayer.create(this, R.raw.alarm3);
        alarmSoundMp3 = MediaPlayer.create(this, R.raw.alarm3);

        backToMain = new Intent(getApplicationContext(), MainActivity.class);
        cancelButton = (Button)findViewById(R.id.cancelBtn);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(backToMain);
           }
       });

        tName1 = (TextView)findViewById(R.id.tvTimer1);
        tName2 = (TextView)findViewById(R.id.tvTimer2);
        tName3 = (TextView)findViewById(R.id.tvTimer3);

        popUp1 = new Intent(this, popup3.class);
        popUp1.putExtra(EXTRA_TITLE1, "TIMER 3");
        startActivityForResult(popUp1, 1);

        popUp2 = new Intent(this, popup3.class);
        popUp2.putExtra(EXTRA_TITLE1, "TIMER 2");
        startActivityForResult(popUp2, 2);

        popUp3 = new Intent(this, popup3.class);
        popUp3.putExtra(EXTRA_TITLE1, "TIMER 1");
        startActivityForResult(popUp3, 3);

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
        //Timer 3
        mTextViewCountDown3 = findViewById(R.id.text_view_countdown3);
        mButtonStartPause3 = findViewById(R.id.buton_start_pause3);
        mButtonStartPause3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimer3Running){
                    pauseTimer3();
                }
                else{
                    startTimer3();
                }
            }
        });
        updateCountDownText3();

        okayButton = findViewById(R.id.okayBtn);
        okayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmSoundMp.stop();
                okayButton.setVisibility(View.INVISIBLE);
                tName1.setVisibility(View.INVISIBLE);
            }
        });

        okayButton2 = findViewById(R.id.okayBtn2);
        okayButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmSoundMp2.stop();
                okayButton2.setVisibility(View.INVISIBLE);
                tName2.setVisibility(View.INVISIBLE);
            }
        });

        okayButton3 = findViewById(R.id.okayBtn3);
        okayButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmSoundMp3.stop();
                okayButton3.setVisibility(View.INVISIBLE);
                tName3.setVisibility(View.INVISIBLE);
            }
        });

    }

    //Timer 1
    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeft, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeft = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                alarmSoundMp.start();
                okayButton.setVisibility(View.VISIBLE);
                tName1.setText(sTimer1Name + " is ready!");
                mTextViewCountDown.setText("00:00");
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
                mTimer2Running = false;
                mButtonStartPause2.setText("Start");
                mButtonStartPause2.setVisibility(View.INVISIBLE);
                alarmSoundMp2.start();
                okayButton2.setVisibility(View.VISIBLE);
                tName2.setText(sTimer2Name + " is ready!");
                mTextViewCountDown2.setText("00:00");
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
    //Timer 3
    private void startTimer3(){
        mCountDownTimer3 = new CountDownTimer(mTimer3MinsLeft, 1000) {
            @Override
            public void onTick(long l) {
                mTimer3MinsLeft = l;
                updateCountDownText3();
            }

            @Override
            public void onFinish() {
                mTimer3Running = false;
                mButtonStartPause3.setText("Start");
                mButtonStartPause3.setVisibility(View.INVISIBLE);
                alarmSoundMp3.start();
                okayButton3.setVisibility(View.VISIBLE);
                tName3.setText(sTimer3Name + " is ready!");
                mTextViewCountDown3.setText("00:00");
                mButtonStartPause3.setVisibility(View.INVISIBLE);
            }
        }.start();
        mTimer3Running = true;
        mButtonStartPause3.setText("pause");
    }
    private void pauseTimer3(){
        mCountDownTimer3.cancel();
        mTimer3Running = false;
        mButtonStartPause3.setText("Start");
    }
    private void updateCountDownText3(){
        int minutes = (int)mTimer3MinsLeft / 1000 / 60;
        int seconds = (int)mTimer3MinsLeft / 1000 % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown3.setText(timeLeftFormatted);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                sTimer1Name=data.getStringExtra("name");
                int iTime1 = data.getIntExtra("time", 0);
                sTimer1Name.toUpperCase();
                tName1.setText(sTimer1Name);
                tName1.setVisibility(View.VISIBLE);
                mTimeLeft = (int)iTime1 * 60000;
                updateCountDownText();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                tName1.setText("No Data Retreived");
            }
        }
        if(requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                sTimer2Name=data.getStringExtra("name");
                int iTime2 = data.getIntExtra("time", 0);
                sTimer2Name.toUpperCase();
                tName2.setText(sTimer2Name);
                tName2.setVisibility(View.VISIBLE);
                mTimer2MinsLeft = (int)iTime2 * 60000;
                updateCountDownText2();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                tName1.setText("No Data Retreived");
            }
        }
        if(requestCode == 3){
            if(resultCode == Activity.RESULT_OK){
                sTimer3Name=data.getStringExtra("name");
                int iTime3 = data.getIntExtra("time", 0);
                sTimer3Name.toUpperCase();
                tName3.setText(sTimer3Name);
                tName3.setVisibility(View.VISIBLE);
                mTimer3MinsLeft = (int)iTime3 * 60000;
                updateCountDownText3();

                mTextViewCountDown.setVisibility(View.VISIBLE);
                mTextViewCountDown2.setVisibility(View.VISIBLE);
                mTextViewCountDown3.setVisibility(View.VISIBLE);
                mButtonStartPause.setVisibility(View.VISIBLE);
                mButtonStartPause2.setVisibility(View.VISIBLE);
                mButtonStartPause3.setVisibility(View.VISIBLE);
                cancelButton.setVisibility(View.VISIBLE);




            }
            if (resultCode == Activity.RESULT_CANCELED) {
                tName1.setText("No Data Retreived");
            }
        }
    }


}
