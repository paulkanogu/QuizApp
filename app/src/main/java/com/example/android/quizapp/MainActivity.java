package com.example.android.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // *Declaration for variable to keep score
    int score = 0;

    // * Declaration of all the correct answer radio buttons
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton4;
    RadioButton radioButton7;
    RadioButton radioButton9;
    RadioButton radioButton10;


    // * Declaration of the check boxes for question 5
    CheckBox q5_box1;
    CheckBox q5_box2;
    CheckBox q5_box3;
    CheckBox q5_box4;

    // * declaration of the check boxes for question 8
    CheckBox q8_box1;
    CheckBox q8_box2;
    CheckBox q8_box3;
    CheckBox q8_box4;

    // * declaration for question 3 & 6 text input
    EditText r3;
    EditText r6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // * Finds the radio buttons with correct answers
        radioButton1 = findViewById(R.id.q1_a2_radio_button);
        radioButton2 = findViewById(R.id.q2_a3_radio_button);
        radioButton4 = findViewById(R.id.q4_a3_radio_button);
        radioButton7 = findViewById(R.id.q7_a1_radio_button);
        radioButton9 = findViewById(R.id.q9_a2_radio_button);
        radioButton10 = findViewById(R.id.q10_a3_radio_button);


        // * Finds the check boxes for question 5
        q5_box1 = findViewById(R.id.q5_a1_check_box);
        q5_box2 = findViewById(R.id.q5_a2_check_box);
        q5_box3 = findViewById(R.id.q5_a3_check_box);
        q5_box4 = findViewById(R.id.q5_a4_check_box);

        // * Finds the check boxes for question 8
        q8_box1 = findViewById(R.id.q8_a1_check_box);
        q8_box2 = findViewById(R.id.q8_a2_check_box);
        q8_box3 = findViewById(R.id.q8_a3_check_box);
        q8_box4 = findViewById(R.id.q8_a4_check_box);

        // * Validates correct answer for question 3 & 6
        r3 = findViewById(R.id.q3_edit_text);
        r6 = findViewById(R.id.q6_edit_text);
    }

    // * This method is loaded when Submit button is clicked
    public void submitAnswer(View view) {

        // * Validates correct answers for question 5
        boolean a5 = !q5_box1.isChecked() && !q5_box3.isChecked() && q5_box2.isChecked() && q5_box4.isChecked();

        // * Validates correct answers for question 8
        boolean a8 = !q8_box1.isChecked() && !q8_box3.isChecked() && q8_box2.isChecked() && q8_box4.isChecked();

        // * Validates correct answer for question 3 & 6
        boolean a3 = (r3.getText().toString().equalsIgnoreCase("47"));
        boolean a6 = (r6.getText().toString().equalsIgnoreCase("nairobi"));

        if (radioButton1.isChecked()) {
            score++;
        } else {
            radioButton1.setTextColor(Color.GREEN);
        }

        if (radioButton2.isChecked()) {
            score++;
        } else {
            radioButton2.setTextColor(Color.GREEN);
        }

        if (radioButton4.isChecked()) {
            score++;
        } else {
            radioButton4.setTextColor(Color.GREEN);
        }

        if (radioButton7.isChecked()) {
            score++;
        } else {
            radioButton7.setTextColor(Color.GREEN);
        }

        if (radioButton9.isChecked()) {
            score++;
        } else {
            radioButton9.setTextColor(Color.GREEN);
        }

        if (radioButton10.isChecked()) {
            score++;
        } else {
            radioButton10.setTextColor(Color.GREEN);
        }

        if (a3) {
            score++;
        } else {
            r3.setText("47");
            r3.setTextColor(Color.GREEN);
        }

        if (a5) {
            score++;
        } else {
            q5_box2.setTextColor(Color.GREEN); //* highlight the correct answers
            q5_box4.setTextColor(Color.GREEN);
        }

        if (a6) {
            score++;
        } else {
            r6.setText("Nairobi");
            r6.setTextColor(Color.GREEN);
        }

        if (a8) {
            score++;
        } else {
            q8_box2.setTextColor(Color.GREEN);
            q8_box4.setTextColor(Color.GREEN);
        }

        //* Checks for correct answers for all questions
        if (radioButton1.isChecked() && radioButton2.isChecked() && radioButton4.isChecked()
                && radioButton7.isChecked() && radioButton9.isChecked() && radioButton10.isChecked()
                && a5 && a3 && a6 && a8) {
            Toast.makeText(this, "Congratulations! You got all of them! Score: "
                    + score, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Oops! You missed some. Your Score: " + score,
                    Toast.LENGTH_SHORT).show();
        }

        // *Resets the score to zero
        score = 0;
    }


    public void reset(View v) {
        clearRadioButtons(R.id.q1_radioGroup);
        clearRadioButtons(R.id.q2_radioGroup);
        clearRadioButtons(R.id.q4_radioGroup);
        clearRadioButtons(R.id.q7_radioGroup);
        clearRadioButtons(R.id.q9_radioGroup);
        clearRadioButtons(R.id.q10_radioGroup);

        radioButton1.setTextColor(Color.BLACK);
        radioButton2.setTextColor(Color.BLACK);
        radioButton4.setTextColor(Color.BLACK);
        radioButton7.setTextColor(Color.BLACK);
        radioButton9.setTextColor(Color.BLACK);
        radioButton10.setTextColor(Color.BLACK);

        q5_box1.setChecked(false);
        q5_box2.setChecked(false);
        q5_box3.setChecked(false);
        q5_box4.setChecked(false);

        q8_box1.setChecked(false);
        q8_box2.setChecked(false);
        q8_box3.setChecked(false);
        q8_box4.setChecked(false);

        q5_box2.setTextColor(Color.BLACK);
        q5_box4.setTextColor(Color.BLACK);
        q8_box2.setTextColor(Color.BLACK);
        q8_box4.setTextColor(Color.BLACK);

        r3.setText("");
        r6.setText("");

        Toast.makeText(this, "Quiz Reset", Toast.LENGTH_LONG).show();

    }

    private void clearRadioButtons(int id) {
        RadioGroup radioGroup = findViewById(id);
        radioGroup.clearCheck();
    }

}