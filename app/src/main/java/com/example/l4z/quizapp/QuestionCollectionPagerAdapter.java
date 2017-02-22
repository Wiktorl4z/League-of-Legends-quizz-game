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
    private final List<Question> question2s;

    public QuestionCollectionPagerAdapter(FragmentManager fm, List<Question> questions) {
        super(fm);
        this.question2s = questions;
    }

    @Override
    public Fragment getItem(int i) {
        Question q = question2s.get(i);
        QuestionFragment fragment = new QuestionFragment();
        fragment.setQuestion(q);
        return fragment;
    }

    @Override
    public int getCount() {
        return question2s.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
}