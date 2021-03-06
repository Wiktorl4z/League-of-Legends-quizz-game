package com.example.l4z.quizapp.activitys;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.l4z.quizapp.R;

import java.util.ArrayList;

import static com.example.l4z.quizapp.activitys.MainActivity.QUESTIONS_INTENT;

public class FinalScreenActivity extends AppCompatActivity {

    private TextView pointsGained, textView;
    private ImageView email, imageView;
    private CheckBox checkBox;
    private Button playAgainButton;
    private String feedback, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        userName = getIntent().getExtras().getString(MainMenu.KOX);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinalScreenActivity.this, MainMenu.class));

            }
        });

        textView = (TextView) findViewById(R.id.text_message);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                feedback = "I want more!";
            } else {
                feedback = "";
            }
        });

        ArrayList<String> list = getIntent().getExtras().getStringArrayList(QUESTIONS_INTENT);
        pointsGained = (TextView) findViewById(R.id.pointsGained);
        pointsGained.setText(list.get(0));
        String imageName = list.get(1);

        imageView = (ImageView) findViewById(R.id.rankImage);
        if (imageName.equals("challenger")) {
            textView.setText("You are Challenger worth");
            imageView.setImageResource(R.drawable.challenger);
        } else if (imageName.equals("diamond")) {
            textView.setText("You are Diamond worth");
            imageView.setImageResource(R.drawable.diamond);
        } else if (imageName.equals("platinum")) {
            textView.setText("You are Platinum worth");
            imageView.setImageResource(R.drawable.platinum);
        } else if (imageName.equals("gold")) {
            textView.setText("You are Gold worth");
            imageView.setImageResource(R.drawable.gold_rank);
        } else if (imageName.equals("bronse")) {
            textView.setText("You are Bronse worth");
            imageView.setImageResource(R.drawable.bronse);
        } else if (imageName.equals("silver")) {
            textView.setText("You are Silver worth");
            imageView.setImageResource(R.drawable.silver);
        }

        email = (ImageView) findViewById(R.id.emailImage);
        email.setOnClickListener((View.OnClickListener) v -> {
            EditText editText = (EditText) findViewById(R.id.feedBackText);
            String comment = editText.getText().toString();
            String commentLike = comment + " " + feedback;
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "WiktorKalinowski@gmail.com", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback Quiz App Game from ");
            intent.putExtra(Intent.EXTRA_TEXT, commentLike);
            try {
                startActivity(Intent.createChooser(intent, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(FinalScreenActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        });

        Context context = getApplicationContext();
        CharSequence text = "Good game " + userName + "!" + "\nYour score:  " + list.get(0) + " out of 12.";

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
