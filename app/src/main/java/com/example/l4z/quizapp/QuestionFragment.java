package com.example.l4z.quizapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionFragment extends Fragment {

    private int points;
    private AnswerType answer = AnswerType.NO_ANSWER;
    private AnswerType correctAnswer;
    public static final String QUESTION_OBJECT = "question";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        correctAnswer=AnswerType.ANSWER_1;
        View rootView = inflater.inflate(R.layout.fragment_question, container, false);
        Bundle args = getArguments();
        ((TextView) rootView.findViewById(R.id.questionID)).setText(args.getString(QUESTION_OBJECT));
        return rootView;
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

