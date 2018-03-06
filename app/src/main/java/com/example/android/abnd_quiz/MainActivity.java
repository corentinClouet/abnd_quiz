package com.example.android.abnd_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    EditText family_name_textView;
    RadioButton birmingham_radioButton;
    CheckBox arthur_checkBox;
    CheckBox chris_checkBox;
    CheckBox bryan_checkBox;
    CheckBox john_checkBox;
    Switch sw_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        family_name_textView = findViewById(R.id.family_name_editview);
        birmingham_radioButton = findViewById(R.id.rb2_radioButton);
        arthur_checkBox = findViewById(R.id.chk1_checkBox);
        chris_checkBox = findViewById(R.id.chk2_checkBox);
        bryan_checkBox = findViewById(R.id.chk3_checkBox);
        john_checkBox = findViewById(R.id.chk4_checkBox);
        sw_switch = findViewById(R.id.sw_switch);
    }

    /*
    * Show the result to the user with a Toast
    */
    public void showResults(View v){
        setResult();
        if (score>2){
            Toast.makeText(this, "Your score is " + score + "/4. Congratulations !", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Your score is " + score + "/4. Try again !", Toast.LENGTH_LONG).show();
        }

        score = 0;
    }

    // Update the score variable to count correct answers
    private void setResult(){
        if (family_name_textView.getText().toString().toLowerCase().equals("shelby"))
            score++;
        if (birmingham_radioButton.isChecked())
            score++;
        if (arthur_checkBox.isChecked() && john_checkBox.isChecked() && !chris_checkBox.isChecked() && !bryan_checkBox.isChecked())
            score++;
        if (sw_switch.isChecked())
            score++;
    }
}
