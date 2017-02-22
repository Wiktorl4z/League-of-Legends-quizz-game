package com.example.l4z.quizapp;

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
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;
    private Button mButtonAnswer;
    private ImageView mImageView;

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_question, container, false);

        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == mButtonAnswer) {
                    int checkedRadioButtonId = mRadioGroup.getCheckedRadioButtonId();
                    Log.v("TAG", checkedRadioButtonId + "");
                    RadioButton viewById = (RadioButton) mRadioGroup.findViewById(checkedRadioButtonId);
                    if (viewById != null) {
                        checkAnswere(question.getCorrectAnswere(), viewById.getText().toString());
                    }
                }
            }
        };

        mQuestion = (TextView) rootView.findViewById(R.id.questionID);
        mRadioGroup = (RadioGroup) rootView.findViewById(R.id.radioButtonID);
        mButtonAnswer = (Button) rootView.findViewById(R.id.buttonAnswer);
        mRadioButton1 = (RadioButton) rootView.findViewById(R.id.answer1);
        mRadioButton2 = (RadioButton) rootView.findViewById(R.id.answer2);
        mRadioButton3 = (RadioButton) rootView.findViewById(R.id.answer3);
        mImageView = (ImageView) rootView.findViewById(R.id.imageView);

        mButtonAnswer.setOnClickListener(listener);

        mQuestion.setText(question.getQuestion());
        mRadioButton1.setText(question.getQuestions().get(0));
        mRadioButton2.setText(question.getQuestions().get(1));
        mRadioButton3.setText(question.getQuestions().get(2));
        mImageView.setImageResource(question.getResImage());

        return rootView;
    }

    private void checkAnswere(String answ, String selected) {
        if (answ.equalsIgnoreCase(selected)) {
            AlertDialog.Builder dialig = new AlertDialog.Builder(getActivity());
            dialig.setMessage("Yo got it right!");
            dialig.show();
        } else {
            AlertDialog.Builder dialig = new AlertDialog.Builder(getActivity());
            dialig.setMessage("Too bad, it's wrong answer!");
            dialig.show();
        }
    }
}

