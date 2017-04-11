package com.example.l4z.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainMenu extends AppCompatActivity {

    private static String userName;
    Button championButton, itemButton, spellsButton;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        editText = (EditText) findViewById(R.id.edit_text_main);
        userName = editText.getText().toString();

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
        intent.putExtra(MainActivity.PRESSED_BUTTON_KEY, b);
        MainMenu.this.startActivity(intent);
    }

    public static String getUserName() {
        return userName;
    }
}
