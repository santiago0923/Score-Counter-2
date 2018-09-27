package com.example.santi.scorecounter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {

    String a;
    EditText lct;
    TextView team;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        team = (TextView) findViewById(R.id.winnerPoints);
        Bundle b1 = getIntent().getExtras();
        Integer s1 = Integer.parseInt(b1.getString("A"));

    //////////////////////////////////////////////////////

        Bundle b2 = getIntent().getExtras();
        Integer s2 = Integer.parseInt(b2.getString("B"));

    ////////////////////////////////////////////
        int s3 = s1 - s2;
        int s4 = s2 - s1;

    //////////////////////////////////////////////////////////
        if (s1 == 5) {
            if ((s1 - s2) > 1) {

                team.setText("Team A has won by " + s3 + " points");

            } else {
                team.setText("Team A has won by " + s3 + " point");
            }
        } else {
            if ((s2 - s1) > 1) {
                team.setText("Team B has won by " + s4 + " points");
            } else {
                team.setText("Team B has won by " + s4 + " point");
            }
        }

    }
 /////////////////////////////////////////////////////////////////////

    public void buttonCall(View view) {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:3475581050"));
        if (call.resolveActivity(getPackageManager()) != null) {
            startActivity(call);
        }

    }

 ///////////////////////////////////////////////////////////////////

    public void buttonSendMessage(View view) {
        //  if () {
        String msg = team.getText().toString();
        Intent passData = new Intent(Intent.ACTION_SEND);
        passData.setType("text/plain");
        passData.putExtra(Intent.EXTRA_TEXT, msg);
        startActivity(Intent.createChooser(passData, "Share via"));

    }

   ////////////////////////////////////////////////////////////////////*/

    public void buttonLocation(View view) {
        Intent geo = new Intent(Intent.ACTION_VIEW);
        if(geo.resolveActivity(getPackageManager()) != null){
            startActivity(geo);
        }
        ///*/

    }

    ///////////////////////////////////////////////////////////*/
        public void button (View view){

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }



}
