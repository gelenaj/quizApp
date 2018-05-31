package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class FinalScoreActivity extends AppCompatActivity {
    int totalScore=MainActivity.q1Score +Question2Activity.q2Score + Question3Activity.q3Score + Question4Activity.q4Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);
        displayFinalScore(totalScore);
    }

    /**
     * Displays final score.
     */
    public void displayFinalScore(int totalScore) {
        TextView scoreView = (TextView) findViewById(R.id.finalScore);
        scoreView.setText(String.valueOf(totalScore));
    }
}
