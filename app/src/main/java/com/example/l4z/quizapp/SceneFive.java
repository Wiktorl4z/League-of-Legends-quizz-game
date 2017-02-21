package com.example.l4z.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class SceneFive extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_five);


        final EditText editText = (EditText)findViewById(R.id.feedBackText);

        ImageView feedBackText = (ImageView)findViewById(R.id.emialID);
        feedBackText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String commit = editText.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:wiktorkalinowski@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding the quiz");
                intent.putExtra(Intent.EXTRA_TEXT, commit);

                startActivity(intent);
            }
        });
    }



}
