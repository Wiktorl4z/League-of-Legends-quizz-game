package com.example.l4z.quizapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class QuestionFragment extends AppCompatActivity {

    private int points;
    private AnswerType answer = AnswerType.NO_ANSWER;
    private AnswerType correctAnswer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_question);
        correctAnswer=AnswerType.ANSWER_1;
    }


    public void goToNext(View view) {
        Intent toMainMenu = new Intent(this, SceneOne.class);
        startActivity(toMainMenu);

    }

    public void checkTheAnswer(View view) {
        if(answer!=AnswerType.NO_ANSWER){
            if (answer == correctAnswer){
                points++;
            } else {
                points--;
            }
        }
    }

    public void answerButtonClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            switch (view.getId()) {
                case R.id.asnwer1:
                    answer = AnswerType.ANSWER_1;
                    break;
                case R.id.asnwer2:
                    answer = AnswerType.ANSWER_2;
                    break;
                case R.id.asnwer3:
                    answer = AnswerType.ANSWER_3;
                    break;
            }
        }
    }
}

