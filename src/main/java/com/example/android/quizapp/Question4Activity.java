package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question4Activity extends AppCompatActivity {
    public static int q4Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
    }

    /**
     * Increases point total by 1 if answered correctly and opens next question.
     */

    public void updateScoreAndGoToNext(View v) {
        CheckBox q4Correct1;
        CheckBox q4Correct2;
        q4Correct1 = (CheckBox) findViewById(R.id.q4CorrectAnswer1);
        q4Correct2 = (CheckBox) findViewById(R.id.q4CorrectAnswer2);
        if (q4Correct1.isChecked() && q4Correct2.isChecked()) {
            q4Score = q4Score + 1;
            Toast toast = Toast.makeText(this, "Great Job! 1 point added.", Toast.LENGTH_SHORT);
            toast.show();
        } else if (q4Correct1.isChecked() || q4Correct2.isChecked()) {
            Toast toast = Toast.makeText(this, "You got one of these right.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            q4Score = 0;
            Toast toast = Toast.makeText(this, "Better luck next time, 0 points added.", Toast.LENGTH_SHORT);
            toast.show();
        }
        Intent i = new Intent(this, FinalScoreActivity.class);
        startActivity(i);
    }
}
