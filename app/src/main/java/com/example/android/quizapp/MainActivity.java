package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
      public static int q1Score= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }
    /**
     * Increases point total by 1 if question is answered correctly and opens next question.
     */
    public void updateQ1scoreAndGoToNext(View view){
        EditText q1Correct;
        q1Correct = (EditText) findViewById(R.id.q1Answer);
        String inputText = q1Correct.getText().toString();
        String rightAnswer = "text";

        if (inputText.equalsIgnoreCase(rightAnswer)) {
            q1Score = q1Score + 1;
            Toast toast = Toast.makeText(this, R.string.GreatJobMsg, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            q1Score = 0;
            Toast toast = Toast.makeText(this, R.string.BetterLuckMsg, Toast.LENGTH_SHORT);
            toast.show();
        }
        Intent i = new Intent(this, Question2Activity.class);
        startActivity(i);
    }

}
