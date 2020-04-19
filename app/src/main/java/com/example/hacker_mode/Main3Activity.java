package com.example.hacker_mode;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    private int currentScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent3 = getIntent();
        currentScore = intent3.getIntExtra(Main2Activity.CURRENT_STREAK,0);

        TextView score = findViewById(R.id.score);
        score.setText(Integer.toString(currentScore));

        final Intent intent4 = new Intent(this,MainActivity.class);

         final TextView timerText = findViewById(R.id.timer2);
         CountDownTimer countDownTimer = new CountDownTimer(5000,1000) {
             @Override
             public void onTick(long millisUntilFinished) {
               timerText.setText(Long.toString(millisUntilFinished/1000));
             }

             @Override
             public void onFinish() {
                startActivity(intent4);
             }
         }.start();
    }
}
