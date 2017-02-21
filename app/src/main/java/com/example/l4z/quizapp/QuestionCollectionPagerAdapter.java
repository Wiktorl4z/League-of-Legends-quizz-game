package com.example.l4z.quizapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * A {@link android.support.v4.app.FragmentStatePagerAdapter} that returns a fragment
 * representing an object in the collection.
 */
public class QuestionCollectionPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Question> questions;

    public QuestionCollectionPagerAdapter(FragmentManager fm, FileHelper fileHelper) {
        super(fm);
        this.questions = fileHelper.getQuestions();
    }

    @Override
    public Fragment getItem(int i) {
        Question q = questions.get(i);
        Fragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(QuestionFragment.QUESTION_OBJECT, q.getQuestion());
        args.putString(QuestionFragment.CORRECT_ANSWER_OBJECT, q.getAnswer());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
}