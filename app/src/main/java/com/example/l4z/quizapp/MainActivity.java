package com.example.l4z.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.l4z.quizapp.information.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String QUESTIONS_INTENT = "questions";
    private QuestionCollectionPagerAdapter mQuestionCollectionPagerAdapter;
    private ViewPager mViewPager;
    private static final List<Question> FAKE_QUESTION = new ArrayList<>();
    private static MainActivity instance;


    static {
        Question questions = new Question(R.drawable.jhin, "What's the name on the champion?", "Jhin");
        questions.addSelection("Graves");
        questions.addSelection("Jhin");
        questions.addSelection("Vayne");
        FAKE_QUESTION.add(questions);

        questions = new Question(R.drawable.katarina, "What's the name on the champion?", "Katarina");
        questions.addSelection("Katarina");
        questions.addSelection("Lux");
        questions.addSelection("Diana");
        FAKE_QUESTION.add(questions);

        questions = new Question(R.drawable.rengar, "What's the name on the champion?", "Rengar");
        questions.addSelection("traxex");
        questions.addSelection("Rengar");
        questions.addSelection("queen of pain");
        FAKE_QUESTION.add(questions);

        questions = new Question(R.drawable.yasuo, "What's the name on the champion?", "yasuo");
        questions.addSelection("zorro");
        questions.addSelection("yasuo");
        questions.addSelection("hero123");
        FAKE_QUESTION.add(questions);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        setContentView(R.layout.activity_main);
        mQuestionCollectionPagerAdapter = new QuestionCollectionPagerAdapter(getSupportFragmentManager(), FAKE_QUESTION);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mQuestionCollectionPagerAdapter);
    }

    /**
     * The {@link android.support.v4.view.ViewPager} that will display the object collection.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public static MainActivity getInstance() {
        return instance;
    }

    public void showFinalScreen() {
        Intent mFinal = new Intent(this, FinalScreenActivity.class);

        List<Question> questions = mQuestionCollectionPagerAdapter.getQuestions();
        ArrayList<String> list = new ArrayList<String>();
        int all = 0;
        int correct = 0;
        for (Question q: questions) {
            if (q.isAnswered()){
                all++;
            }
            if (q.isAnsweredCorrect()){
                correct++;
            }
        }
        list.add("Odpowiedziales na " + all);
        list.add("Odpowiedziales poprawnie " + correct);
        mFinal.putStringArrayListExtra(QUESTIONS_INTENT,list);
        startActivity(mFinal);
    }
}
