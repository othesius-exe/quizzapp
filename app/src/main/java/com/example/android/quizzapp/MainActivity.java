package com.example.android.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Evaluates the score for question 1. 2 points possible
     */
    public int questionOne() {
        CheckBox pebbles = (CheckBox) findViewById(R.id.checkbox_1);
        CheckBox wood = (CheckBox) findViewById(R.id.checkbox_2);
        CheckBox aDuck = (CheckBox) findViewById(R.id.checkbox_3);
        CheckBox aWitch = (CheckBox) findViewById(R.id.checkbox_4);
        if (!pebbles.isChecked() && wood.isChecked() && aDuck.isChecked() && !aWitch.isChecked()) {
            score += 2;
        }
        return score;
    }

    /**
     * Evaluates Score for question 2. 1 point possible.
     */

    public int questionTwo() {
        RadioButton aButton = (RadioButton) findViewById(R.id.a_button);
        if (aButton.isChecked()) {
            score += 1;
        }
        return score;
    }

    /**
     * @return Checks that the user knows their name. 1 point possible if names match
     */
    public int getName() {
        EditText nameView = (EditText) findViewById(R.id.name_bar);
        EditText nameQuestion = (EditText) findViewById(R.id.name_question);
        String nameOne = nameView.getText().toString().toLowerCase().trim();
        String nameTwo = nameQuestion.getText().toString().toLowerCase().trim();
        if (!nameOne.equals("") && nameOne.equals(nameTwo)) {
            score += 1;
        }
        return score;
    }

    /**
     * Evaluates the score for question 4. 1 point possible.
     */

    public int questionFour() {
        RadioButton trueButton = (RadioButton) findViewById(R.id.radio_true);
        if (trueButton.isChecked()) {
            score += 1;
        }
        return score;
    }

    /**
     * Evaluates the answer for question 5. Worth 5 points.
     */
    public int questionFive() {
        EditText response = (EditText) findViewById(R.id.question_five_text);
        String userResponse = response.getText().toString().trim();
        if (userResponse.equals("1998")) {
            score += 5;
        }
        return score;
    }

    /**
     * @param view On Button Click this will calculate the grade and present a toast with the score.
     */
    public void gradeQuiz(View view) {
        questionOne();
        questionTwo();
        getName();
        questionFour();
        questionFive();

        Toast finalGrade = Toast.makeText(MainActivity.this, "Your total score is: " + score + "/10", Toast.LENGTH_LONG);
        finalGrade.show();

        /**
         * Clears all fields
         */
        RadioGroup radioGroupOne = (RadioGroup) findViewById(R.id.swallow_radio_group);
        RadioGroup radioGroupTwo = (RadioGroup) findViewById(R.id.true_or_false_radio);
        radioGroupOne.clearCheck();
        radioGroupTwo.clearCheck();
        CheckBox pebbles = (CheckBox) findViewById(R.id.checkbox_1);
        CheckBox wood = (CheckBox) findViewById(R.id.checkbox_2);
        CheckBox aDuck = (CheckBox) findViewById(R.id.checkbox_3);
        CheckBox aWitch = (CheckBox) findViewById(R.id.checkbox_4);
        pebbles.setChecked(false);
        wood.setChecked(false);
        aDuck.setChecked(false);
        aWitch.setChecked(false);
        EditText response = (EditText) findViewById(R.id.question_five_text);
        response.setText("");
        EditText nameView = (EditText) findViewById(R.id.name_bar);
        nameView.setText("");
        EditText nameQuestion = (EditText) findViewById(R.id.name_question);
        nameQuestion.setText("");

        score = 0;
    }
}
