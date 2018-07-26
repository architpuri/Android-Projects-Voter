package com.example.architpuri.voter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Final_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final__screen);
        TextView result_txtview =(TextView)findViewById(R.id.res_txtview);

        boolean success_bool = getIntent().getBooleanExtra("success_bool", false);
        if (success_bool = true) {
            result_txtview.setText("Successful Voting");
            //Voting is not successful
        } else {
            result_txtview.setText("Un-Successful Voting");
            //Voting is not successful
        }
    }
}
