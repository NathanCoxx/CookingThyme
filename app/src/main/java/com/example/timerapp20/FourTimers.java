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

public class FourTimers extends AppCompatActivity {
    private static final long START_TIME = 60000;
    public static final String EXTRA_TITLE1 = "com.example.timerapp20.EXTRA_TITLE1";
    Intent popUp1;
    Intent popUp2;
    Intent popUp3;
    Intent popUp4;
    Intent backToMain;

    //Media Players
    private MediaPlayer alarmSoundMp;
    private MediaPlayer alarmSoundMp2;
    private MediaPlayer alarmSoundMp3;
    private MediaPlayer alarmSoundMp4;

    //alarm finish
    private Button okayButton;
    private Button okayButton2;
    private Button okayButton3;
    private Button okayButton4;

    //Timer 1
    private EditText timer1Name;
    private EditText timer1Time;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeft;

    //Timer 2
    private EditText timer2Name;
    private EditText timer2Time;
    private TextView mTextViewCountDown2;
    private Button mButtonStartPause2;
    private CountDownTimer mCountDownTimer2;
    private boolean mTimer2Running;
    private long mTimer2MinsLeft;

    //Timer 3
    private  EditText timer3Time;
    private EditText timer3Name;
    private TextView mTextViewCountDown3;
    private Button mButtonStartPause3;
    private CountDownTimer mCountDownTimer3;
    private boolean mTimer3Running;
    private long mTimer3MinsLeft;

    //Timer 4
    private EditText timer4Name;
    private EditText timer4Time;
    private TextView mTextViewCountDown4;
    private Button mButtonStartPause4;
    private CountDownTimer mCountDownTimer4;
    private boolean mTimer4Running;
    private long mTimer4MinsLeft;

    //SetTimerAttributes
    private int iTime1;
    private int iTime2;
    private int iTime3;
    private int iTime4;
    private String sTimer1Name;
    private String sTimer2Name;
    private String sTimer3Name;
    private String sTimer4Name;
    private TextView tName1;
    private TextView tName2;
    private TextView tName3;
    private TextView tName4;
    private Button setButton1;
    private Button setButton2;
    private Button setButton3;
    private Button setButton4;
    private Button addTimer2;
    private Button addTimer3;
    private Button addTimer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_timers);

        alarmSoundMp = MediaPlayer.create(this, R.raw.alarm3);
        alarmSoundMp2 = MediaPlayer.create(this, R.raw.alarm3);
        alarmSoundMp3 = MediaPlayer.create(this, R.raw.alarm3);
        alarmSoundMp4 = MediaPlayer.create(this, R.raw.alarm3);

        tName1 = (TextView)findViewById(R.id.tvTime1);
        tName2 = (TextView)findViewById(R.id.tvTime2);
        tName3 = (TextView)findViewById(R.id.tvTime3);
        tName4 = (TextView)findViewById(R.id.tvTime4);

        popUp1 = new Intent(this, PopActivity4.class);
        popUp1.putExtra(EXTRA_TITLE1, "TIMER 4");
        startActivityForResult(popUp1, 1);

        popUp2 = new Intent(this, PopActivity4.class);
        popUp2.putExtra(EXTRA_TITLE1, "TIMER 3");
        startActivityForResult(popUp2, 2);

        popUp3 = new Intent(this, PopActivity4.class);
        popUp3.putExtra(EXTRA_TITLE1, "TIMER 2");
        startActivityForResult(popUp3, 3);

        popUp4 = new Intent(this, PopActivity4.class);
        popUp4.putExtra(EXTRA_TITLE1, "TIMER 1");
        startActivityForResult(popUp4, 4);

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
        //Timer 4
        mTextViewCountDown4 = findViewById(R.id.text_view_countdown4);
        mButtonStartPause4 = findViewById(R.id.buton_start_pause4);
        mButtonStartPause4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimer4Running){
                    pauseTimer4();
                }
                else{
                    startTimer4();
                }
            }
        });
        updateCountDownText();


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
        okayButton4 = findViewById(R.id.okayBtn4);
        okayButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmSoundMp4.stop();
                okayButton4.setVisibility(View.INVISIBLE);
                tName4.setVisibility(View.INVISIBLE);
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

    //Timer 4
    private void startTimer4(){
        mCountDownTimer4 = new CountDownTimer(mTimer4MinsLeft, 1000) {
            @Override
            public void onTick(long l) {
                mTimer4MinsLeft = l;
                updateCountDownText4();
            }

            @Override
            public void onFinish() {
                mTimer4Running = false;
                mButtonStartPause4.setText("Start");
                mButtonStartPause4.setVisibility(View.INVISIBLE);
                alarmSoundMp4.start();
                okayButton4.setVisibility(View.VISIBLE);
                tName4.setText(sTimer4Name + " is ready!");
                mTextViewCountDown4.setText("00:00");
                mButtonStartPause4.setVisibility(View.INVISIBLE);
            }
        }.start();
        mTimer4Running = true;
        mButtonStartPause4.setText("Pause");
    }
    private void pauseTimer4(){
        mCountDownTimer4.cancel();
        mTimer4Running = false;
        mButtonStartPause4.setText("Start");

    }
    private void updateCountDownText4(){
        int minutes = (int)mTimer4MinsLeft / 1000 / 60;
        int seconds = (int)mTimer4MinsLeft / 1000 % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown4.setText(timeLeftFormatted);
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
        if (requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                sTimer2Name=data.getStringExtra("name");
                int iTime2 = data.getIntExtra("time", 0);
                tName2.setText(sTimer2Name);
                mTimer2MinsLeft = (int)iTime2 * 60000;
                updateCountDownText2();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                tName1.setText("No Data Retreived");
            }
        }
        if (requestCode == 3) {
            if(resultCode == Activity.RESULT_OK){
                sTimer3Name=data.getStringExtra("name");
                int iTime3 = data.getIntExtra("time", 0);
                tName3.setText(sTimer3Name);
                mTimer3MinsLeft = (int)iTime3 * 60000;
                updateCountDownText3();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                tName1.setText("No Data Retreived");
            }
        }
        if(requestCode == 4){
            if(resultCode == Activity.RESULT_OK){
                sTimer4Name=data.getStringExtra("name");
                int iTime4 = data.getIntExtra("time", 0);
                tName4.setText(sTimer4Name);
                mTimer4MinsLeft = (int)iTime4 * 60000;
                updateCountDownText4();

                mTextViewCountDown.setVisibility(View.VISIBLE);
                mTextViewCountDown2.setVisibility(View.VISIBLE);
                mButtonStartPause.setVisibility(View.VISIBLE);
                mButtonStartPause2.setVisibility(View.VISIBLE);
                mTextViewCountDown3.setVisibility(View.VISIBLE);
                mTextViewCountDown4.setVisibility(View.VISIBLE);
                mButtonStartPause3.setVisibility(View.VISIBLE);
                mButtonStartPause4.setVisibility(View.VISIBLE);
                tName2.setVisibility(View.VISIBLE);
                tName3.setVisibility(View.VISIBLE);
                tName4.setVisibility(View.VISIBLE);


            }
            if (resultCode == Activity.RESULT_CANCELED) {
                tName1.setText("No Data Retreived");
            }
        }
    }
}
