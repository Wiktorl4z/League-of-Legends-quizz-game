package com.example.l4z.quizapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.l4z.quizapp.information.Question;

import java.util.List;

/**
 * A {@link android.support.v4.app.FragmentStatePagerAdapter} that returns a fragment
 * representing an object in the collection.
 */
public class QuestionCollectionPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Question> questions;

    public QuestionCollectionPagerAdapter(FragmentManager fm, List<Question> questions) {
        super(fm);
        this.questions = questions;
    }

    @Override
    public Fragment getItem(int i) {
        Question q = questions.get(i);
        QuestionFragment fragment = new QuestionFragment();
        fragment.setQuestion(q);
        if (i == getCount() - 1) {
            fragment.setLastQuestion(true);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return questions.size();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "QUESTION " + (position + 1);
    }
}