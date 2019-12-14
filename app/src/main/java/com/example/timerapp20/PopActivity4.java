package com.example.timerapp20;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PopActivity4 extends Activity {
    public static final String EXTRA_NAME = "com.example.timerapp20.EXTRA_NAME";
    public static final String EXTRA_MINS = "com.example.timerapp20.EXTRA_MINS";

    private EditText etName;
    private EditText etTime;
    private String name;
    private int time;
    private Button nextBtn;
    private Button doneBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop4);


        DisplayMetrics dn = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dn);

        int width = dn.widthPixels;
        int height = dn.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.5));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        Intent intent = getIntent();
        TextView title = (TextView)findViewById(R.id.tvTitle);
        title.setText(intent.getStringExtra(FourTimers.EXTRA_TITLE1));

        nextBtn = (Button)findViewById(R.id.nextBtn);
        etName = (EditText)findViewById(R.id.etTimerName);
        etTime = (EditText)findViewById(R.id.etTimerMin);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = etName.getText().toString();
                name = name.toUpperCase();
                time = Integer.parseInt(etTime.getText().toString());
                Intent resultIntent = new Intent();
                resultIntent.putExtra("time", time);
                resultIntent.putExtra("name", name);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();


            }
        });


    }
}
