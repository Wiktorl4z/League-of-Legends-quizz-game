package com.example.l4z.quizapp.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.l4z.quizapp.R;

public class MainMenu extends AppCompatActivity {

    public static final String KOX = "userName";
    Button championButton, itemButton, spellsButton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        editText = (EditText) findViewById(R.id.edit_text_main);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                boolean textChecker = !s.toString().trim().isEmpty();

                championButton.setEnabled(textChecker);
                itemButton.setEnabled(textChecker);
                spellsButton.setEnabled(textChecker);
            }
        });

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
        intent.putExtra(MainMenu.KOX, editText.getText().toString());
        MainMenu.this.startActivity(intent);
    }
}
