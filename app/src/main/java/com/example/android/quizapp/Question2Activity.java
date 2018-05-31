package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Question2Activity extends AppCompatActivity {
    public static int q2Score = 0;
    TextView q2ProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        q2ProgressBar=findViewById(R.id.totalPoints);
        q2ProgressBar.setText(R.string.question2_of_4);

     final Button openQ3button = findViewById(R.id.checkScoreAndNext);
        openQ3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQ2scoreAndGoToNext(openQ3button);
            }
        });
    }
    /**
     * Increases point total by 1 if answered correctly and goes to next question.
     */
    public void updateQ2scoreAndGoToNext(View v){
    RadioButton q2Correct;
    q2Correct = (RadioButton) findViewById(R.id.q2CorrectAnswer);
        if(q2Correct.isChecked()){
        q2Score = q2Score + 1;
        Toast toast = Toast.makeText(this,R.string.GreatJobMsg, Toast.LENGTH_SHORT);
        toast.show();
        }
        else {
            q2Score = 0;
            Toast toast = Toast.makeText(this,R.string.BetterLuckMsg, Toast.LENGTH_SHORT);
            toast.show();
        }
        Intent i = new Intent(this, Question3Activity.class);
        startActivity(i);
    }

}
