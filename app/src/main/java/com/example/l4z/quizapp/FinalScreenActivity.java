package com.example.l4z.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import static com.example.l4z.quizapp.MainActivity.QUESTIONS_INTENT;

public class FinalScreenActivity extends AppCompatActivity {

    TextView pointsGained;
    ImageView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        ArrayList<String> list = getIntent().getExtras().getStringArrayList(QUESTIONS_INTENT);
        pointsGained = (TextView) findViewById(R.id.pointsGained);
        pointsGained.setText(list.get(0));
        String imageName = list.get(1);

        ImageView imageView = (ImageView) findViewById(R.id.rankImage);
        if (imageName.equals("challenger")) {
            imageView.setImageResource(R.drawable.challenger);
        } else if (imageName.equals("gold")) {
            imageView.setImageResource(R.drawable.gold_rank);
        } else if (imageName.equals("bronze")) {
            imageView.setImageResource(R.drawable.bronze_rank);
        }

        email = (ImageView)findViewById(R.id.emailImage);
        email.setOnClickListener((View.OnClickListener) v -> {
            EditText editText = (EditText) findViewById(R.id.feedBackText);
            String comment = editText.getText().toString();
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","WiktorKalinowski@email.com", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Wiadomosc Quiz App");
            intent.putExtra(Intent.EXTRA_TEXT, comment);
            try {
                startActivity(Intent.createChooser(intent, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(FinalScreenActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        });
    }
}
