package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question2Activity extends AppCompatActivity {
    public static int q2Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
    }

    /**
     * Increases point total by 1 if answered correctly and goes to next question.
     */
    public void updateQ2scoreAndGoToNext(View v){
    RadioButton q2Correct;
    q2Correct = (RadioButton) findViewById(R.id.q2CorrectAnswer);
        if(q2Correct.isChecked()){
        q2Score = q2Score + 1;
        Toast toast = Toast.makeText(this, "Great Job! 1 point added.", Toast.LENGTH_SHORT);
        toast.show();
        }
        else {
            q2Score = 0;
            Toast toast = Toast.makeText(this, "Better luck next time, 0 points added.", Toast.LENGTH_SHORT);
            toast.show();
        }
        Intent i = new Intent(this, Question3Activity.class);
        startActivity(i);
    }

}
