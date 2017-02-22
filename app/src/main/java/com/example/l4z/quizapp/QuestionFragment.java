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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionFragment extends Fragment {

    private static int points;
    private AnswerType answer = AnswerType.NO_ANSWER;
    private AnswerType correctAnswer;
    public static final String QUESTION_OBJECT = "question";
    public static final String CORRECT_ANSWER_OBJECT = "correct_answer";
    private static Random random = new Random();
    private List<String> answerStrings = new ArrayList<>(3);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        for(int i=0;i<3;i++){
            answerStrings.add(null);
        }
        correctAnswer = AnswerType.ANSWER_1;
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
        int rnd = random.nextInt(3);
        answerStrings.add(rnd, args.getString(CORRECT_ANSWER_OBJECT));
        switch (rnd) {
            case 0:
                correctAnswer = AnswerType.ANSWER_1;
                break;
            case 1:
                correctAnswer = AnswerType.ANSWER_2;
                break;
            case 2:
                correctAnswer = AnswerType.ANSWER_3;
                break;
        }
        fillTheRest();
        ((RadioButton) rootView.findViewById(R.id.answer1)).setText(answerStrings.get(0));
        ((RadioButton) rootView.findViewById(R.id.answer2)).setText(answerStrings.get(1));
        ((RadioButton) rootView.findViewById(R.id.answer3)).setText(answerStrings.get(2));
        return rootView;
    }

    private void fillTheRest() {
        String[] names = MainActivity.getNames();
        for (int i = 0; i < 3; i++) {
            if (answerStrings.get(i) == null) {
                String name = getRandom(names);
                answerStrings.add(i, name);
            }
        }
    }

    public String getRandom(String[] a) {
        String s;
        do {
            int rnd = random.nextInt(a.length - 1);
            s = a[rnd];
        } while (answerStrings.contains(s));
        return s;
    }

    public void checkTheAnswer(View view) {
        if (answer != AnswerType.NO_ANSWER) {
            if (answer == correctAnswer) {
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

