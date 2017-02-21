package com.example.l4z.quizapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionFragment extends Fragment {

    private static int points;
    private AnswerType answer = AnswerType.NO_ANSWER;
    private AnswerType correctAnswer;
    public static final String QUESTION_OBJECT = "question";
    public static final String CORRECT_ANSWER_OBJECT = "correct_answer";
    private static Random random= new Random();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        correctAnswer=AnswerType.ANSWER_1;
        View rootView = inflater.inflate(R.layout.fragment_question, container, false);
        rootView.findViewById(R.id.buttonAnswer).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTheAnswer(view);
            }
        });
        rootView.findViewById(R.id.answer1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButtonClick(view);
            }
        });
        rootView.findViewById(R.id.answer2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButtonClick(view);
            }
        });
        rootView.findViewById(R.id.answer3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                answerButtonClick(view);
            }
        });
        Bundle args = getArguments();
        ((TextView) rootView.findViewById(R.id.questionID)).setText(args.getString(QUESTION_OBJECT));
        int rnd = random.nextInt(3)+1;
        switch(rnd){
            case 1:
            ((RadioButton) rootView.findViewById(R.id.answer1)).setText(args.getString(CORRECT_ANSWER_OBJECT));
                correctAnswer=AnswerType.ANSWER_1;
                break;
            case 2:
                ((RadioButton) rootView.findViewById(R.id.answer2)).setText(args.getString(CORRECT_ANSWER_OBJECT));
                correctAnswer=AnswerType.ANSWER_2;
                break;
            case 3:
                ((RadioButton) rootView.findViewById(R.id.answer3)).setText(args.getString(CORRECT_ANSWER_OBJECT));
                correctAnswer=AnswerType.ANSWER_3;
                break;
            default:
                ((RadioButton) rootView.findViewById(R.id.answer1)).setText(args.getString(CORRECT_ANSWER_OBJECT));
                correctAnswer=AnswerType.ANSWER_1;
        }
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

