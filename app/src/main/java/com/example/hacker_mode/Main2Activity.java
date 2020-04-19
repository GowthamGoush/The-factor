package com.example.hacker_mode;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    public static final String CURRENT_STREAK = "com.example.hacker_mode_CURRENT_STREAK";
    int[] factor = new int[20];
    int i,count=0,num1=0,num2=0,num3=0,x=0,y=0,z,ans;
    Random rnd = new Random();
    int answerClicked = 0;
    public int highScore = 0,currentScore=0;
    public static final String SCORE = "Score";
    public static final String HIGH_SCORE = "High Score";
    public static final String CURRENT_SCORE = "Current Score";
    Vibrator vibrator;
    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences(SCORE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(CURRENT_SCORE,0);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.display);
        final TextView textView1 = findViewById(R.id.output);
        final TextView textView2 = findViewById(R.id.output2);

        TextView scoreboard = findViewById(R.id.Scoreboard);
        TextView scoreboard2 = findViewById(R.id.highScore);

        SharedPreferences sharedPreferences = getSharedPreferences(SCORE,MODE_PRIVATE);
        currentScore = sharedPreferences.getInt(CURRENT_SCORE,0);
        highScore = sharedPreferences.getInt(HIGH_SCORE,0);

        if(currentScore>highScore){
            highScore=currentScore;
            saveHighscore();
        }

        scoreboard.setText(Integer.toString(currentScore));
        scoreboard2.setText(Integer.toString(highScore));

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        Intent intent = getIntent();
        i = intent.getIntExtra(MainActivity.EXTRA_NUMBER,0);

        final Intent intent2 = new Intent(this,Main3Activity.class);

        textView.setEms(15);
        textView.setText("Find the factor of "+Integer.toString(i));

        factor = Factor(i);

        x=generator2();
        y=generator2();
        z=generator2();

        num1 = generator(x);
        num2 = generator(y);
        num3 = generator(z);

        Random rnd = new Random();

        button1.setText(Integer.toString(num1));
        button2.setText(Integer.toString(num2));
        button3.setText(Integer.toString(num3));

        if(i%num1==0){
            ans=num1;
        }
        else if(i%num2==0){
            ans=num2;
        }
        else {
            ans=num3;
        }
        final TextView timer = findViewById(R.id.timer);
        final CountDownTimer countDownTimer = new CountDownTimer(11000,1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(Long.toString(millisUntilFinished/1000));
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                intent2.putExtra(CURRENT_STREAK,currentScore);
                wrongAnswer();
                startActivity(intent2);

            }
        };
        countDownTimer.start();

        final Intent intent1 = new Intent(this,Main4Activity.class);

        final CountDownTimer countDownTimer1 = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                intent1.putExtra(CURRENT_STREAK,currentScore);
                startActivity(intent1);
            }
        };

        final Intent intent3 = new Intent(this,MainActivity.class);
        final CountDownTimer countDownTimer2 = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(intent3);
            }
        };

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        final RelativeLayout relativeLayout = findViewById(R.id.layout);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i%num1==0 && answerClicked==0){
                    textView1.setEms(8);
                    textView1.setText("Correct Answer!");
                    relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
                    answerClicked = 1;
                    countDownTimer.cancel();
                    saveData();
                    countDownTimer2.start();
                }
                else if(answerClicked==0) {
                    textView1.setEms(8);
                    textView1.setText("Wrong Answer!");
                    textView2.setEms(15);
                    textView2.setText("The correct answer is "+Integer.toString(ans));
                    relativeLayout.setBackgroundColor(getResources().getColor(R.color.red));
                    answerClicked = 1;
                    countDownTimer.cancel();
                    countDownTimer1.start();
                    wrongAnswer();
                    vibrator.vibrate(1000);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i%num2==0 && answerClicked==0){
                    textView1.setEms(8);
                    textView1.setText("Correct Answer!");
                    relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
                    answerClicked = 1;
                    countDownTimer.cancel();
                    saveData();
                    countDownTimer2.start();
                }
                else if(answerClicked==0) {
                    textView1.setEms(8);
                    textView1.setText("Wrong Answer!");
                    textView2.setEms(15);
                    textView2.setText("The correct answer is "+Integer.toString(ans));
                    relativeLayout.setBackgroundColor(getResources().getColor(R.color.red));
                    answerClicked = 1;
                    countDownTimer.cancel();
                    countDownTimer1.start();
                    wrongAnswer();
                    vibrator.vibrate(1000);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i%num3==0 && answerClicked==0){
                    textView1.setEms(8);
                    textView1.setText("Correct Answer!");
                    relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
                    answerClicked = 1;
                    countDownTimer.cancel();
                    saveData();
                    countDownTimer2.start();
                }
                else if(answerClicked==0) {
                    textView1.setEms(8);
                    textView1.setText("Wrong Answer!");
                    textView2.setEms(15);
                    textView2.setText("The correct answer is "+Integer.toString(ans));
                    relativeLayout.setBackgroundColor(getResources().getColor(R.color.red));
                    answerClicked = 1;
                    countDownTimer.cancel();
                    countDownTimer1.start();
                    wrongAnswer();
                    vibrator.vibrate(1000);
                }
            }
        });

        Button trybtn = findViewById(R.id.trybtn);
        trybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerClicked==0) {
                    answerClicked = 0;
                    startActivity(intent3);
                }
            }
        });

    }

    public int[] Factor(int f){

        int[] fac;
        fac = new int[20];
        int k;

        for(k=2;k<=f;k++){

            if(f%k==0 && count<20){
                fac[count]=k;
                count=count+1;
            }
        }
        count=count-2;
        return fac;

    }

    public int generator(int num){

        Random random = new Random();

        if(num==1){
            int rnum=0;
            rnum= factor[random.nextInt(count+1)];
            return rnum;
        }
        else if(num==2){
            int rnum=0,m=0;
            while(rnum>=0){
                rnum = random.nextInt(i)+2;
                for(int l=0;l<=count;l++){
                    if(rnum != factor[l]){
                        m++;
                    }
                }
                if(m==count+1){
                    return rnum;
                }
                m=0;
            }

        }
        else if(num==3){

            int rnum=0,m=0;
            while(rnum>=0){
                rnum = random.nextInt(i)+2;
                for(int l=0;l<=count;l++){
                    if(rnum != factor[l]){
                        m++;
                    }
                }
                if(m==count+1){
                    return rnum;
                }
                m=0;
            }
        }
        return 0;
    }
    public int generator2(){

        int temp=0;
        if(x==0){
            return rnd.nextInt(3)+1;
        }
        else if(z==0 && y==0){
            for(int g=0;g<100;g++){
                temp=rnd.nextInt(3)+1;
                if(temp!=x){
                    return temp;
                }
            }
        }
        else {
            for(int g=0;g<100;g++){
                temp=rnd.nextInt(3)+1;
                if(temp!=x && temp!=y){
                    return temp;
                }
            }
        }
        return 0;
    }
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SCORE,MODE_PRIVATE);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(CURRENT_SCORE,currentScore+1);
        editor.apply();
    }
    private void saveHighscore() {
        SharedPreferences sharedPreferences = getSharedPreferences(SCORE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(HIGH_SCORE,highScore);
        editor.apply();
    }
    private void wrongAnswer(){
        SharedPreferences sharedPreferences = getSharedPreferences(SCORE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(CURRENT_SCORE,0);
        editor.apply();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        SharedPreferences sharedPreferences = getSharedPreferences(SCORE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(CURRENT_SCORE,0);
        editor.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(SCORE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(CURRENT_SCORE,0);
        editor.apply();
    }
}
