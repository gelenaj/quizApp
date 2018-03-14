package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Question3Activity extends AppCompatActivity {
    public static int q3Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
    }

    /**
     * Increases point total by 1 if answered correctly and opens next question.
     */
    public void updateQ3scoreAndGoToNext(View v) {
        RadioButton q3Correct;
        q3Correct = (RadioButton) findViewById(R.id.q3CorrectAnswer);
        if (q3Correct.isChecked()) {
            q3Score = q3Score + 1;
            Toast toast = Toast.makeText(this, "Great Job! 1 point added.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            q3Score = 0;
            Toast toast = Toast.makeText(this, "Better luck next time, 0 points added.", Toast.LENGTH_SHORT);
            toast.show();
            Intent i = new Intent(this, Question4Activity.class);
            startActivity(i);
        }
        Intent i = new Intent(this, Question4Activity.class);
        startActivity(i);
    }
}