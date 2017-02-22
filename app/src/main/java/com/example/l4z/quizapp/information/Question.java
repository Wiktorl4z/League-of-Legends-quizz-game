package com.example.l4z.quizapp.information;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private int mImageRes;
    private String mProblem;
    private List<String> selection;
    private String correctAnswere;

    public Question(int intImage, String mProblem, String correctAnswere) {
        mImageRes = intImage;
        selection = new ArrayList<>();
        this.correctAnswere = correctAnswere;
        this.mProblem = mProblem;
    }

    public int getResImage() {
        return mImageRes;
    }

    public String getQuestion() {
        return mProblem;
    }

    public void addSelection(String selection2) {
        selection.add(selection2);
    }

    public List<String> getQuestions() {
        return selection;
    }

    public String getCorrectAnswere() {
        return correctAnswere;
    }
}
