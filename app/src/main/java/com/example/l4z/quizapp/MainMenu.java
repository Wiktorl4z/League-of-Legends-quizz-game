package com.example.l4z.quizapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class MainMenu extends AppCompatActivity {

    private int points;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    public void goToNext (View view){
        Intent toMainMenu = new Intent(this, SceneOne.class);
        startActivity(toMainMenu);

    }
public void checkTheAnswer (View view){
    boolean checked = ((RadioButton) view).isChecked();

    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.asnwer1:
            if (checked)
                // Pirates are the best
                break;
        case R.id.asnwer2:
            if (checked)
                // Ninjas rule
                break;
        case R.id.asnwer3:
            if (checked)
                // Ninjas rule
                break;
    }



}


}
