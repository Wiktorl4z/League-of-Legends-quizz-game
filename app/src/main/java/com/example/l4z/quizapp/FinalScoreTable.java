package com.example.l4z.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class FinalScoreTable extends AppCompatActivity {

    private ArrayList<String[]> ScoreTableArrayList = new ArrayList<String[]>();
    public String[] ScoreTableArray = new String[2]; // Use this string to seperate
    public String[] ScoreTableArray2 = new String[2]; // Use this st
    String PlayerName = "Player";
    int TotalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }



    private void GetScoreTable() throws IOException {
        //https://github.com/kcochibili/TinyDB--Android-Shared-Preferences-Turbo
        //http://stackoverflow.com/questions/7057845/save-arraylist-to-sharedpreferences


        TinyDB tinydb = new TinyDB(this);

        //restore string
        String data = tinydb.getString("ScoreTable");

        // If string is empty
        if (data.equals("")) {
            Log.d("ScoreTable", "Data String is empty");
            // fill table with start values
            for (int i = 0; i <= 9; ++i) {
                data = data + "Player" + "\t" + "0" + "\n";
            }
            Log.d("ScoreTable", "Crerating Data String" + data);
        }
        //put string in to table
        ScoreTableArrayList.clear();
        String[] separated = data.split("\n");
        for (int i = 0; i <= 9; ++i) {
            ScoreTableArray = (separated[i].split("\t"));
            ScoreTableArrayList.add(i, ScoreTableArray);
        }

        //sort table
        // Sorting Procedure and adding new score
        ScoreTableArray = ScoreTableArrayList.get(9);
        if (Integer.parseInt(ScoreTableArray[1]) < TotalScore) {
            if (PlayerName.equals("")) PlayerName = "No Name"; // check if player name is empty
            ScoreTableArray[0] = PlayerName;
            ScoreTableArray[1] = Integer.toString(TotalScore);
            ScoreTableArrayList.set(9, ScoreTableArray);
            int i = 8;
            boolean done = false;
            while (i >= 0 && !done) {
                ScoreTableArray = ScoreTableArrayList.get(i);
                ScoreTableArray2 = ScoreTableArrayList.get(i + 1);
                if (Integer.parseInt(ScoreTableArray[1]) < Integer.parseInt(ScoreTableArray2[1])) {
                    ScoreTableArrayList.set(i, ScoreTableArray2);
                    ScoreTableArrayList.set(i + 1, ScoreTableArray);
                    i = i - 1;
                } else {
                    done = true;
                }
            }
        }

        //save string
        data = "";
        // Recreate data string
        for (int i = 0; i <= 9; ++i) {
            ScoreTableArray = ScoreTableArrayList.get(i);
            data = data + ScoreTableArray[0] + "\t" + ScoreTableArray[1] + "\n";
        }
        tinydb.putString("ScoreTable", data);

    }

    // Language methods
    // check locatrion and if it's greek set the question file this with greeks.


}
