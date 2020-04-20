package com.example.hacker_mode;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NUMBER = "com.example.application.example.EXTRA_NUMBER";
    int count1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @SuppressLint("SetTextI18n")
    public void Onclick(View v){
        EditText editText = findViewById(R.id.input);
        TextView textView = findViewById(R.id.msg);

        Intent intent = new Intent(this,Main2Activity.class);

        Boolean enteredNumber;
        String input = editText.getText().toString();
        enteredNumber = numberOrNot(input);
        if(enteredNumber==true) {
            int number = Integer.parseInt(editText.getText().toString());
            int d;
            for (d = 2; d <= number; d++) {

                if (number % d == 0) {
                    count1 = count1 + 1;
                }
            }
            if (count1 == 0 || count1 == 1) {
                textView.setEms(11);
                textView.setText("Try with another number!");
                count1 = 0;
                return;
            }
            count1 = 0;

            intent.putExtra(EXTRA_NUMBER, number);

            startActivity(intent);
        }
        else {
            textView.setEms(10);
            textView.setText("Enter a valid input!");
        }


    }

    static boolean numberOrNot(String input)
    {
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }
}
