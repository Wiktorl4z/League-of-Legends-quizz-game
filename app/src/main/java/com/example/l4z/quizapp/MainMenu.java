package com.example.l4z.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button championButton, itemButton, spellsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        championButton = (Button) findViewById(R.id.championButton);
        championButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(MainMenu.this, MainActivity.class);
                MainMenu.this.startActivity(main);
            }
        });

        itemButton = (Button) findViewById(R.id.itemButton);
        itemButton.setOnClickListener(v -> {
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
        });

        spellsButton = (Button) findViewById(R.id.spellsButton);
        spellsButton.setOnClickListener(v -> {
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
        });
    }
}
