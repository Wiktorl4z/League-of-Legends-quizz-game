package com.example.l4z.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.l4z.quizapp.MainActivity.QUESTIONS_INTENT;

public class FinalScreenActivity extends AppCompatActivity{

    TextView pointsGained;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        ArrayList<String> list = getIntent().getExtras().getStringArrayList(QUESTIONS_INTENT);
        pointsGained = (TextView)findViewById(R.id.pointsGained);
        pointsGained.setText(list.get(0)+ list.get(1));

    }


}
