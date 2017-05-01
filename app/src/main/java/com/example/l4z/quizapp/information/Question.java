package com.example.l4z.quizapp.information;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {

    private int mImageRes;
    private String mProblem;
    private List<String> selection;
    private String correctAnswer;
    private boolean answered;
    private boolean answeredCorrect;

    public Question(int intImage, String mProblem, String correctAnswer) {
        mImageRes = intImage;
        selection = new ArrayList<>();
        this.correctAnswer = correctAnswer;
        this.mProblem = mProblem;
    }

    public boolean isAnsweredCorrect() {
        return answeredCorrect;
    }

    public void setAnsweredCorrect(boolean answeredCorrect) {
        this.answeredCorrect = answeredCorrect;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
