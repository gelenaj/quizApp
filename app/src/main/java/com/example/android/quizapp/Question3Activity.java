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

import static com.example.android.quizapp.R.string.question3_of_4;

public class Question3Activity extends AppCompatActivity {
    public static int q3Score = 0;
    TextView q3ProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        q3ProgressBar=(TextView)findViewById(R.id.totalPoints);
        q3ProgressBar.setText(question3_of_4);

        final Button openQ4button = findViewById(R.id.checkScoreAndNext);
        openQ4button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQ3scoreAndGoToNext(openQ4button);
            }
        });
    }
    /**
     * Increases point total by 1 if answered correctly and opens next question.
     */
    public void updateQ3scoreAndGoToNext(View v) {
        RadioButton q3Correct;
        q3Correct = (RadioButton) findViewById(R.id.q3CorrectAnswer);
        if (q3Correct.isChecked()) {
            q3Score = q3Score + 1;
            Toast toast = Toast.makeText(this,R.string.GreatJobMsg, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            q3Score = 0;
            Toast toast = Toast.makeText(this, R.string.BetterLuckMsg, Toast.LENGTH_SHORT);
            toast.show();
            Intent i = new Intent(this, Question4Activity.class);
            startActivity(i);
        }
        Intent i = new Intent(this, Question4Activity.class);
        startActivity(i);
    }
}