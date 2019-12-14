package com.example.timerapp20;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class CANTimers extends AppCompatActivity {


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
        setContentView(R.layout.activity_can_timers);

        timer2Name = findViewById(R.id.etTimer2Name);
        timer2Time = findViewById(R.id.etTimer2Min);
        timer1Name = findViewById(R.id.etTimer1Name);
        timer1Time = findViewById(R.id.etTimer1Min);
        timer3Name = findViewById(R.id.etTimer3Name);
        timer3Time = findViewById(R.id.etTimer3Min);
        timer4Name = findViewById(R.id.etTimer4Name);
        timer4Time = findViewById(R.id.etTimer4Min);

        addTimer2 = (Button)findViewById(R.id.addTimer2Btn);
        addTimer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTimer2.setVisibility(View.INVISIBLE);
                mTextViewCountDown2.setVisibility(View.VISIBLE);
                mButtonStartPause2.setVisibility(View.VISIBLE);
                timer2Name.setVisibility(View.VISIBLE);
                timer2Time.setVisibility(View.VISIBLE);
                setButton2.setVisibility(View.VISIBLE);
            }
        });

        addTimer3 = (Button)findViewById(R.id.addTimer3Btn);
        addTimer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTimer3.setVisibility(View.INVISIBLE);
                mTextViewCountDown3.setVisibility(View.VISIBLE);
                mButtonStartPause3.setVisibility(View.VISIBLE);
                timer3Name.setVisibility(View.VISIBLE);
                timer3Time.setVisibility(View.VISIBLE);
                setButton3.setVisibility(View.VISIBLE);
            }
        });

        addTimer4 = (Button) findViewById(R.id.addTimer4Btn);
        addTimer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTimer4.setVisibility(View.INVISIBLE);
                mTextViewCountDown4.setVisibility(View.VISIBLE);
                mButtonStartPause4.setVisibility(View.VISIBLE);
                timer4Name.setVisibility(View.VISIBLE);
                timer4Time.setVisibility(View.VISIBLE);
                setButton4.setVisibility(View.VISIBLE);
            }
        });

        setButton1 = findViewById(R.id.set_button);
        setButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sTimer1Name = timer1Name.getText().toString();
                sTimer1Name.toUpperCase();
                iTime1 = Integer.parseInt(timer1Time.getText().toString());

                setButton1.setVisibility(View.INVISIBLE);
                timer1Name.setVisibility(View.INVISIBLE);
                timer1Time.setVisibility(View.INVISIBLE);

                tName1 = (TextView)findViewById(R.id.tvTimer1);
                tName1.setText(sTimer1Name);
                tName1.setVisibility(View.VISIBLE);
                mTimeLeft = (int)iTime1 * 60000;
                updateCountDownText();
            }
        });

        setButton2 = findViewById(R.id.set_button2);
        setButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sTimer2Name = timer2Name.getText().toString();
                sTimer2Name.toUpperCase();
                iTime2 = Integer.parseInt(timer2Time.getText().toString());

                setButton2.setVisibility(View.INVISIBLE);
                timer2Name.setVisibility(View.INVISIBLE);
                timer2Time.setVisibility(View.INVISIBLE);

                tName2 = (TextView)findViewById(R.id.tvTimer2);
                tName2.setText(sTimer2Name);
                tName2.setVisibility(View.VISIBLE);
                mTimer2MinsLeft = (int)iTime2 * 60000;
                updateCountDownText2();
            }
        });

        setButton3 = findViewById(R.id.set_button3);
        setButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sTimer3Name = timer3Name.getText().toString();
                sTimer3Name.toUpperCase();
                iTime3 = Integer.parseInt(timer3Time.getText().toString());

                setButton3.setVisibility(View.INVISIBLE);
                timer3Name.setVisibility(View.INVISIBLE);
                timer3Time.setVisibility(View.INVISIBLE);

                tName3 = (TextView)findViewById(R.id.tvTimer3);
                tName3.setText(sTimer3Name);
                tName3.setVisibility(View.VISIBLE);
                mTimer3MinsLeft = (int)iTime3 * 60000;
                updateCountDownText3();
            }
        });

        setButton4 = findViewById(R.id.set_button4);
        setButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sTimer4Name = timer4Name.getText().toString();
                sTimer4Name.toUpperCase();
                iTime4 = Integer.parseInt(timer4Time.getText().toString());

                setButton4.setVisibility(View.INVISIBLE);
                timer4Name.setVisibility(View.INVISIBLE);
                timer4Time.setVisibility(View.INVISIBLE);

                tName4 = (TextView)findViewById(R.id.tvTimer4);
                tName4.setText(sTimer4Name);
                tName4.setVisibility(View.VISIBLE);
                mTimer4MinsLeft = (int)iTime4 * 60000;
                updateCountDownText4();
            }
        });

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

}
