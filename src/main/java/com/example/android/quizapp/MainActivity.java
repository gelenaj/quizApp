package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
//    public RadioButton q1Correct = (RadioButton) findViewById(R.id.q1CorrectAnswer);
      public static int q1Score= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increases point total by 1 if question is answered correctly and opens next question.
     */

    public void updateQ4scoreAndGoToNext(View view){
        EditText q1Correct;
        q1Correct = (EditText) findViewById(R.id.q1Answer);
        String inputText = q1Correct.getText().toString();
        String rightAnswer = "TextView";

        if (inputText.equals(rightAnswer)) {
            q1Score = q1Score + 1;
            Toast toast = Toast.makeText(this, "Great Job! 1 point added.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            q1Score = 0;
            Toast toast = Toast.makeText(this, "Better luck next time, 0 points added.", Toast.LENGTH_SHORT);
            toast.show();
        }

        Intent i = new Intent(this, Question2Activity.class);
        startActivity(i);
    }

}
