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
    private static final List<Question> FAKE_CHAMPIONS_QUESTION = new ArrayList<>();
    private static final List<Question> FAKE_ITEM_QUESTION = new ArrayList<>();
    private static final List<Question> FAKE_SPELLS_QUESTION = new ArrayList<>();
    private static MainActivity instance;
    public static final String PRESSED_BUTTON_KEY = "mainMenuButton";


    static {
        Question questions = new Question(R.drawable.jhin, "What's the name on the champion?", "Jhin");
        questions.addSelection("Graves");
        questions.addSelection("Jhin");
        questions.addSelection("Vayne");
        FAKE_CHAMPIONS_QUESTION.add(questions);

        questions = new Question(R.drawable.katarina, "What's the name on the champion?", "Katarina");
        questions.addSelection("Katarina");
        questions.addSelection("Lux");
        questions.addSelection("Diana");
        FAKE_CHAMPIONS_QUESTION.add(questions);

        questions = new Question(R.drawable.rengar, "What's the name on the champion?", "Rengar");
        questions.addSelection("traxex");
        questions.addSelection("Rengar");
        questions.addSelection("queen of pain");
        FAKE_CHAMPIONS_QUESTION.add(questions);

        questions = new Question(R.drawable.yasuo, "What's the name on the champion?", "yasuo");
        questions.addSelection("zorro");
        questions.addSelection("yasuo");
        questions.addSelection("hero123");
        FAKE_CHAMPIONS_QUESTION.add(questions);
    }

    static {
        Question questions = new Question(R.drawable.zonia, "What's the name on the Item?", "zhonyas");
        questions.addSelection("Graves");
        questions.addSelection("zhonyas");
        questions.addSelection("Vayne");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable.frozen, "What's the name on the Item?", "frozen");
        questions.addSelection("Katarina");
        questions.addSelection("Lux");
        questions.addSelection("frozen");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable.seraph100, "What's the name on the Item?", "seraphs");
        questions.addSelection("seraphs");
        questions.addSelection("liandrys");
        questions.addSelection("queen of pain");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable. meja, "What's the name on the Item?", "mejais");
        questions.addSelection("zorro");
        questions.addSelection("mejais");
        questions.addSelection("hero123");
        FAKE_ITEM_QUESTION.add(questions);
    }

    static {
        Question questions = new Question(R.drawable.ignite, "What's the name on the spell?", "ignite");
        questions.addSelection("ignite");
        questions.addSelection("teleport");
        questions.addSelection("Barier");
        FAKE_SPELLS_QUESTION.add(questions);

        questions = new Question(R.drawable.heal, "What's the name on the spell?", "heal");
        questions.addSelection("heal");
        questions.addSelection("teleport");
        questions.addSelection("Barier");
        FAKE_SPELLS_QUESTION.add(questions);

        questions = new Question(R.drawable.mark, "What's the name on the spell?", "mark");
        questions.addSelection("teleport");
        questions.addSelection("Barier");
        questions.addSelection("mark");
        FAKE_SPELLS_QUESTION.add(questions);

        questions = new Question(R.drawable.smite, "What's the name on the spell?", "smite");
        questions.addSelection("smite");
        questions.addSelection("teleport");
        questions.addSelection("Barier");
        FAKE_SPELLS_QUESTION.add(questions);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        setContentView(R.layout.activity_main);
        byte b = getIntent().getExtras().getByte(PRESSED_BUTTON_KEY);
        switch (b) {
            case 0:
                mQuestionCollectionPagerAdapter = new QuestionCollectionPagerAdapter(getSupportFragmentManager(), FAKE_CHAMPIONS_QUESTION);
                break;
            case 1:
                mQuestionCollectionPagerAdapter = new QuestionCollectionPagerAdapter(getSupportFragmentManager(), FAKE_ITEM_QUESTION);
                break;
            case 2:
                mQuestionCollectionPagerAdapter = new QuestionCollectionPagerAdapter(getSupportFragmentManager(), FAKE_SPELLS_QUESTION);
                break;
        }
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
        int answered = 0;
        int correct = 0;
        int all = questions.size();

        for (Question q : questions) {
            if (q.isAnswered()) {
                answered++;
            }
            if (q.isAnsweredCorrect()) {
                correct++;
            }
        }

        String image;
        if (correct == all) {
            image = "challenger";
        } else if (correct > all / 2) {
            image = "gold";
        } else {
            image = "bronze";
        }


        list.add("Odpowiedziales poprawnie na " + correct + " pytan z " + all + " zadanych.");
        list.add(image);
        mFinal.putStringArrayListExtra(QUESTIONS_INTENT, list);
        startActivity(mFinal);
    }
}
