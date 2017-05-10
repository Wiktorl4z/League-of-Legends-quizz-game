package com.example.l4z.quizapp.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.l4z.quizapp.R;

public class StartupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
    }

    public void onImageClick(View view) {
        Intent mainActivity = new Intent(this, MainMenu.class);
        startActivity(mainActivity);
    }
}
