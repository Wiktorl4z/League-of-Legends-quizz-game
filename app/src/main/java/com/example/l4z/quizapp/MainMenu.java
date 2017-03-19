package com.example.l4z.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button championButton, itemButton, spellsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        championButton = (Button) findViewById(R.id.championButton);
        championButton.setOnClickListener(v -> {
            startQuiz((byte) 0);
        });

        itemButton = (Button) findViewById(R.id.itemButton);
        itemButton.setOnClickListener(v -> {
            startQuiz((byte) 1);
        });

        spellsButton = (Button) findViewById(R.id.spellsButton);
        spellsButton.setOnClickListener(v -> {
            startQuiz((byte) 2);
        });
    }

    private void startQuiz(byte b) {
        Intent intent = new Intent(MainMenu.this, MainActivity.class);
        intent.putExtra(MainActivity.PRESSED_BUTTON_KEY,b);
        MainMenu.this.startActivity(intent);
    }
}
