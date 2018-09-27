package com.example.santi.scorecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

       int scoreTeamA = 0;
       int scoreTeamB = 0;



    ///////////////////////////////////////////////////////////////////////////////////////////

    public void addOnePointForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);

    }

///////////////////////////////////////////////////////////////////////////////////////////
    //Display the given point to team A
    public void displayForTeamA(int score) {
        if (score < 5) {
            TextView scoreViewA = (TextView) findViewById(R.id.textViewA);
            scoreViewA.setText(String.valueOf(score));
        } else {
            TextView scoreViewA = (TextView) findViewById(R.id.textViewA);
            scoreViewA.setText(String.valueOf(score));
            int pointsA = scoreTeamA - scoreTeamB;
            Intent passDataA = new Intent(this, WinnerActivity.class);
            passDataA.putExtra("B", String.valueOf(scoreTeamB));
            passDataA.putExtra("A", String.valueOf(scoreTeamA));

            startActivity(passDataA);

        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////

    //increase the points of team B by one
    public void addOnePointForTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);

    }

    //Display the given point to team B
    public void displayForTeamB(int score) {
        if (score < 5){
            TextView scoreViewB = (TextView) findViewById(R.id.textViewB);
            scoreViewB.setText(String.valueOf(score));
    }else{
            TextView scoreViewB = (TextView) findViewById(R.id.textViewB);
            scoreViewB.setText(String.valueOf(score));
            int pointsB = scoreTeamB - scoreTeamA;
            Intent passDataB = new Intent(this, WinnerActivity.class);
            passDataB.putExtra("B", String.valueOf(scoreTeamB));
             passDataB.putExtra("A", String.valueOf(scoreTeamA));
            startActivity(passDataB);
         }

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void reset(View view){
        scoreTeamA =0;
        scoreTeamB = 0;
        displayForTeamA(0);
        displayForTeamB(0);


    }
  }
