package com.example.l4z.quizapp;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.l4z.quizapp.information.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final List<Question> FAKE_QUESTION = new ArrayList<>();

    static {
        Question questions = new Question(R.drawable.jhin,"Who is the strongest hero?", "balanar");
        questions.addSelection("traxex");
        questions.addSelection("balanar");
        questions.addSelection("queen of pain");
        FAKE_QUESTION.add(questions);

        questions = new Question(R.drawable.katarina,"Who is best LiveEdu streamer?", "Wiktor-l4z");
        questions.addSelection("ad-master");
        questions.addSelection("r2t8");
        questions.addSelection("Wiktor-l4z");
        FAKE_QUESTION.add(questions);

        questions = new Question(R.drawable.rengar,"What's the name on the champion", "rengar");
        questions.addSelection("traxex");
        questions.addSelection("rengar");
        questions.addSelection("queen of pain");
        FAKE_QUESTION.add(questions);

        questions = new Question(R.drawable.yasuo,"Who is the strongest hero?", "yasuo");
        questions.addSelection("zorro");
        questions.addSelection("yasuo");
        questions.addSelection("hero123");
        FAKE_QUESTION.add(questions);
    }


    private QuestionCollectionPagerAdapter mQuestionCollectionPagerAdapter;

    /**
     * The {@link android.support.v4.view.ViewPager} that will display the object collection.
     */
    private ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mQuestionCollectionPagerAdapter = new QuestionCollectionPagerAdapter(getSupportFragmentManager(), FAKE_QUESTION);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mQuestionCollectionPagerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
