package com.example.architpuri.voter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Voting_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting__screen);
        Button party_btn_bjp = (Button) findViewById(R.id.btn_bjp);
        party_btn_bjp.setOnClickListener(vote_listener);
        Button party_btn_cng = (Button) findViewById(R.id.btn_cng);
        party_btn_cng.setOnClickListener(vote_listener);
        Button party_btn_aap = (Button) findViewById(R.id.btn_aap);
        party_btn_aap.setOnClickListener(vote_listener);
        Button party_btn_sad = (Button) findViewById(R.id.btn_sad);
        party_btn_sad.setOnClickListener(vote_listener);
    }

    private View.OnClickListener vote_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean a = castVote(v);
            if(a==true)
            {
                //Successfull Voting
                Intent intent = new Intent(v.getContext(),Final_Screen.class);//check
                intent.putExtra("success_bool",a);
                startActivity(intent);
            }
        }
    };
    protected boolean castVote(View view) {
        boolean success = false;
        int party = 0;
        switch (view.getId()) {
            case R.id.btn_bjp:
                party = 1;
            case R.id.btn_cng:
                party = 2;
            case R.id.btn_aap:
                party = 3;
            case R.id.btn_sad:
                party = 4;
        }
        voting_blockchain(party);
        if (party != 0) {
            success = true;
        }
        return success;
    }
    private static void voting_blockchain(int party_code) {

    }
}