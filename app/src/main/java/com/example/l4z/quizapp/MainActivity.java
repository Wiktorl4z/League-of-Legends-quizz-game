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
        questions.addSelection("Darius");
        questions.addSelection("Rengar");
        questions.addSelection("Ezreal");
        FAKE_CHAMPIONS_QUESTION.add(questions);

        questions = new Question(R.drawable.yasuo, "What's the name on the champion?", "Yasuo");
        questions.addSelection("Yasuo");
        questions.addSelection("Yorick");
        questions.addSelection("Zed");
        FAKE_CHAMPIONS_QUESTION.add(questions);

        questions = new Question(R.drawable.ahri, "What's the name on the champion?", "Ahri");
        questions.addSelection("Ahri");
        questions.addSelection("Zyra");
        questions.addSelection("Tristana");
        FAKE_CHAMPIONS_QUESTION.add(questions);

        questions = new Question(R.drawable.aurelio_sol, "What's the name on the champion?", "Aurelion Sol");
        questions.addSelection("Cassiopeia");
        questions.addSelection("Camille");
        questions.addSelection("Aurelion Sol");
        FAKE_CHAMPIONS_QUESTION.add(questions);

        questions = new Question(R.drawable.ashe, "What's the name on the champion?", "Ashe");
        questions.addSelection("Ashe");
        questions.addSelection("Caitlyn");
        questions.addSelection("Akali");
        FAKE_CHAMPIONS_QUESTION.add(questions);

        questions = new Question(R.drawable.kog_maw, "What's the name on the champion?", "Kog'Maw");
        questions.addSelection("Malphite");
        questions.addSelection("Kog'Maw");
        questions.addSelection("Nautilus");
        FAKE_CHAMPIONS_QUESTION.add(questions);

        questions = new Question(R.drawable.galio, "What's the name on the champion?", "Galio");
        questions.addSelection("Kled");
        questions.addSelection("Galio");
        questions.addSelection("Mordekaiser");
        FAKE_CHAMPIONS_QUESTION.add(questions);

        questions = new Question(R.drawable.talon, "What's the name on the champion?", "Talon");
        questions.addSelection("Olaf");
        questions.addSelection("Nasus");
        questions.addSelection("Talon");
        FAKE_CHAMPIONS_QUESTION.add(questions);

    }

    static {
        Question questions = new Question(R.drawable.zonia, "What's the name on the Item?", "Zhonya's Hourglass");
        questions.addSelection("Zz'Rot Portal");
        questions.addSelection("Zhonya's Hourglass");
        questions.addSelection("Zeke's Harbinger");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable.frozen, "What's the name on the Item?", "Frozen Mallet");
        questions.addSelection("Frozen Heart");
        questions.addSelection("Frozen Hammer");
        questions.addSelection("Frozen Mallet");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable.seraph100, "What's the name on the Item?", "Seraph's Embrace");
        questions.addSelection("Seraph's Embrace");
        questions.addSelection("Serrated Dirk");
        questions.addSelection("Sheen");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable.meja, "What's the name on the Item?", "Mejai's Soulstealer");
        questions.addSelection("Mercurial Scimitar");
        questions.addSelection("Mikael's Crucible");
        questions.addSelection("Mejai's Soulstealer");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable.crystal_scepte, "What's the name on the Item?", "Rylai's Crystal Scepter");
        questions.addSelection("Seeker's Armguard");
        questions.addSelection("Rylai's Crystal Scepter");
        questions.addSelection("Redemption");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable.gunblade, "What's the name on the Item?", "Hextech Gunblade");
        questions.addSelection("Iceborn Gauntlet");
        questions.addSelection("Kircheis Shard");
        questions.addSelection("Hextech Gunblade");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable.hexdrinker, "What's the name on the Item?", "Hexdrinker");
        questions.addSelection("Hexdrinker");
        questions.addSelection("Last Whisper");
        questions.addSelection("Lich Bane");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable.hunter_potion, "What's the name on the Item?", "Hunter's Potion");
        questions.addSelection("Hunter's Potion");
        questions.addSelection("Health Potion");
        questions.addSelection("Refillable Potion");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable.void_staff, "What's the name on the Item?", "Void Staff");
        questions.addSelection("Archangel's Staff");
        questions.addSelection("Void Staff");
        questions.addSelection("Vanguard Banner");
        FAKE_ITEM_QUESTION.add(questions);

        questions = new Question(R.drawable.wrath, "What's the name on the Item?", "Elixir of Wrath");
        questions.addSelection("Elixir of Iron");
        questions.addSelection("Elixir of Sorcery");
        questions.addSelection("Elixir of Wrath");
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

        questions = new Question(R.drawable.smite, "What's the name on the spell?", "smite");
        questions.addSelection("smite");
        questions.addSelection("teleport");
        questions.addSelection("Barier");
        FAKE_SPELLS_QUESTION.add(questions);

        questions = new Question(R.drawable.dash, "What's the name on the spell?", "dash");
        questions.addSelection("dash");
        questions.addSelection("teleport");
        questions.addSelection("Barier");
        FAKE_SPELLS_QUESTION.add(questions);

        questions = new Question(R.drawable.teleport, "What's the name on the spell?", "teleport");
        questions.addSelection("dash");
        questions.addSelection("teleport");
        questions.addSelection("Barier");
        FAKE_SPELLS_QUESTION.add(questions);

        questions = new Question(R.drawable.exhaust, "What's the name on the spell?", "exhaust");
        questions.addSelection("dash");
        questions.addSelection("teleport");
        questions.addSelection("exhaust");
        FAKE_SPELLS_QUESTION.add(questions);

        questions = new Question(R.drawable.flash, "What's the name on the spell?", "flash");
        questions.addSelection("dash");
        questions.addSelection("teleport");
        questions.addSelection("flash");
        FAKE_SPELLS_QUESTION.add(questions);

        questions = new Question(R.drawable.mark, "What's the name on the spell?", "mark");
        questions.addSelection("mark");
        questions.addSelection("teleport");
        questions.addSelection("flash");
        FAKE_SPELLS_QUESTION.add(questions);

        questions = new Question(R.drawable.ghost, "What's the name on the spell?", "ghost");
        questions.addSelection("mark");
        questions.addSelection("ghost");
        questions.addSelection("flash");
        FAKE_SPELLS_QUESTION.add(questions);

        questions = new Question(R.drawable.cleanse, "What's the name on the spell?", "cleanse");
        questions.addSelection("mark");
        questions.addSelection("ghost");
        questions.addSelection("cleanse");
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
