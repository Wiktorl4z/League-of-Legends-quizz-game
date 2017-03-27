package com.example.l4z.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.l4z.quizapp.information.Question;

public class QuestionFragment extends Fragment {

    private Question question;
    private TextView mQuestion;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1,mRadioButton2,mRadioButton3;
    private Button mButtonAnswer,buttonAnswer;
    private ImageView mImageView;
    private boolean lastQuestion;

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_question, container, false);

        OnClickListener listener = view -> QuestionFragment.this.onAnswerClick(view);

        mQuestion = (TextView) rootView.findViewById(R.id.questionID);
        mRadioGroup = (RadioGroup) rootView.findViewById(R.id.radioButtonID);
        mButtonAnswer = (Button) rootView.findViewById(R.id.buttonAnswer);
        mRadioButton1 = (RadioButton) rootView.findViewById(R.id.answer1);
        mRadioButton2 = (RadioButton) rootView.findViewById(R.id.answer2);
        mRadioButton3 = (RadioButton) rootView.findViewById(R.id.answer3);
        mImageView = (ImageView) rootView.findViewById(R.id.imageView);
        buttonAnswer = (Button) rootView.findViewById(R.id.buttonAnswer);

        mButtonAnswer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionFragment.this.showAnswers();
            }
        });

        if(lastQuestion){
            buttonAnswer.setVisibility(View.VISIBLE);
        }

        mQuestion.setText(question.getQuestion());
        mRadioButton1.setText(question.getQuestions().get(0));
        mRadioButton1.setOnClickListener(listener);
        mRadioButton2.setText(question.getQuestions().get(1));
        mRadioButton2.setOnClickListener(listener);
        mRadioButton3.setText(question.getQuestions().get(2));
        mRadioButton3.setOnClickListener(listener);
        mImageView.setImageResource(question.getResImage());
        return rootView;
    }

    private void showAnswers() {
        MainActivity.getInstance().showFinalScreen();
    }

    private void onAnswerClick(View view) {
        if (view == mRadioButton1 || view == mRadioButton2 || view == mRadioButton3) {
            int checkedRadioButtonId = mRadioGroup.getCheckedRadioButtonId();
            Log.v("TAG", checkedRadioButtonId + "");
            RadioButton viewById = (RadioButton) mRadioGroup.findViewById(checkedRadioButtonId);
            if (viewById != null) {
                checkAnswer(viewById.getText().toString());
            }
        }
    }

    private void checkAnswer(String selected) {
        String answ = question.getCorrectAnswer();
        question.setAnswered(true);
        if (answ.equalsIgnoreCase(selected)) {
            question.setAnsweredCorrect(true);
        } else {
            question.setAnsweredCorrect(false);
        }
    }

    public void setLastQuestion(boolean lastQuestion) {
        this.lastQuestion = lastQuestion;
    }
}

