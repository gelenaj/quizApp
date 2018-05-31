package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quizapp.R.string.final_score;
import static com.example.android.quizapp.R.string.question4_of_4;


public class Question4Activity extends AppCompatActivity {
    public static int q4Score = 0;
    public int numberOfCheckboxesChecked = 0;
    TextView q4ProgressBar;

    CheckBox check1, check2, check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        q4ProgressBar=(TextView)findViewById(R.id.totalPoints);
        q4ProgressBar.setText(question4_of_4);

        final Button openFinalScore = findViewById(R.id.checkScoreAndNext);
        openFinalScore.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  updateScoreAndGoToNext(openFinalScore);
                                              }
        });
        check1 = (CheckBox) findViewById(R.id.q4CorrectAnswer1);
        check2 = (CheckBox) findViewById(R.id.q4WrongAnswer);
        check3 = (CheckBox) findViewById(R.id.q4CorrectAnswer2);

        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (numberOfCheckboxesChecked == 2 && b) {
                    cb.setChecked(false);
                    Toast.makeText(getApplicationContext(),
                            R.string.SelectOnlyTwoMsg, Toast.LENGTH_SHORT).show();
                } else if (b) {
                    numberOfCheckboxesChecked++;

                } else if (!b) {
                    numberOfCheckboxesChecked--;
                }
            }

            ;
        });

        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (numberOfCheckboxesChecked == 2 && b) {
                    cb.setChecked(false);
                    Toast.makeText(getApplicationContext(),
                            R.string.SelectOnlyTwoMsg, Toast.LENGTH_SHORT).show();
                } else if (b) {
                    numberOfCheckboxesChecked++;

                } else if (!b) {
                    numberOfCheckboxesChecked--;
                }
            }

            ;
        });

        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (numberOfCheckboxesChecked == 2 && b) {
                    cb.setChecked(false);
                    Toast.makeText(getApplicationContext(),
                            R.string.SelectOnlyTwoMsg, Toast.LENGTH_SHORT).show();
                } else if (b) {
                    numberOfCheckboxesChecked++;

                } else if (!b) {
                    numberOfCheckboxesChecked--;
                }
            }

            ;
        });


    }

    /**
     * Increases point total by 1 if answered correctly and opens next question.
     */

    public void updateScoreAndGoToNext(View v) {
        CheckBox q4Correct1;
        CheckBox q4Correct2;
        CheckBox q4WrongAnswer;

        q4Correct1 = (CheckBox) findViewById(R.id.q4CorrectAnswer1);
        q4Correct2 = (CheckBox) findViewById(R.id.q4CorrectAnswer2);
        q4WrongAnswer=(CheckBox) findViewById(R.id.q4WrongAnswer);

        if (q4Correct1.isChecked() && q4Correct2.isChecked() && !q4WrongAnswer.isChecked()) {
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
