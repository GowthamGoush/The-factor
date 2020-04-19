package com.example.hacker_mode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        TextView score = findViewById(R.id.Score);

        final Intent intent5 = getIntent();
        int board = intent5.getIntExtra(Main2Activity.CURRENT_STREAK,0);

        score.setText(Integer.toString(board));

        final Intent intent6 = new Intent(this,MainActivity.class);

        final TextView timer3 = findViewById(R.id.timer3);

        CountDownTimer countDownTimer = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer3.setText(Long.toString(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                startActivity(intent6);
            }
        }.start();


    }
}
