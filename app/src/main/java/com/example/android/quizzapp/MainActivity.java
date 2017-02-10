package com.example.android.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * Evaluates the score for question 1. 2 points possible
     */
    public int questionOne() {
        CheckBox pebbles = (CheckBox) findViewById(R.id.checkbox_1);
        CheckBox wood = (CheckBox) findViewById(R.id.checkbox_2);
        CheckBox aDuck = (CheckBox) findViewById(R.id.checkbox_3);
        CheckBox aWitch = (CheckBox) findViewById(R.id.checkbox_4);

        if (pebbles.isChecked()) {
            score += 0;
        }
        if (wood.isChecked()) {
            score += 1;
        }
        if (aDuck.isChecked()) {
            score += 1;
        }
        if (aWitch.isChecked()) {
            score += 0;
        }
        return score;
    }
    /**
     * Evaluates Score for question 2. 1 point possible.
     */

    public int questionTwo() {
        RadioButton aButton = (RadioButton) findViewById(R.id.a_button);
        RadioButton bButton = (RadioButton) findViewById(R.id.b_button);
        RadioButton cButton = (RadioButton) findViewById(R.id.c_button);

        if (aButton.isChecked()) {
            score += 1;
        } else {
            score += 0;
        }
        return score;
    }

    /**
     *
     * @return Checks that the user knows their name. 1 point possible if names match
     */
    public int getName() {
        EditText nameView = (EditText) findViewById(R.id.name_bar);
        EditText nameQuestion = (EditText) findViewById(R.id.name_question);

        if (nameQuestion == nameView) {
            score += 1;
        }
        return score;
    }
    /**
     * Evaluates the score for question 4. 1 point possible.
     */

    public int questionFour() {
        RadioButton trueButton = (RadioButton) findViewById(R.id.radio_true);
        RadioButton falseButton = (RadioButton) findViewById(R.id.radio_false);

        if (trueButton.isChecked()){
            score += 1;
        }
        return score;
    }
    /**
     * Evaluates the answer for question 5. Worth 5 points.
     */


    /**
     *
     * @param view On Button Click this will calculate the grade and present a toast with the score.
     */
    public void gradeQuiz(View view) {
        questionOne();
        questionTwo();
        getName();
        questionFour();

        Toast finalGrade = Toast.makeText(MainActivity.this, "Your total score is: " + score, Toast.LENGTH_LONG);
        finalGrade.show();
    }
}
