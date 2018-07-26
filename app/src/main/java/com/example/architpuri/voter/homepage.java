package com.example.architpuri.voter;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

public class homepage extends AppCompatActivity {
    EditText aadhar_no,area_code,mob_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Button vote_btn = (Button) findViewById(R.id.vote_btn);
        aadhar_no = (EditText)findViewById(R.id.aadhar_txt);
        area_code = (EditText)findViewById(R.id.area_txt);
        mob_no = (EditText)findViewById(R.id.mob_txt);
        vote_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vote_btn_click(v);
            }
        });
    }
    protected void vote_btn_click(View view){
        boolean x = identity_checker();
        boolean a = vote_checker();
        if(x==true)
        {
            //person identified
            if(a==false)
            {
                //cast vote set boolean to 1
                Intent intent = new Intent(this,Voting_Screen.class);
                startActivity(intent);
            }
            else
            {
                //Go to final Screen and write Already Voted
                Intent intent = new Intent(this,Final_Screen.class);
                startActivity(intent);
            }
        }
        else
        {
            //wrong info
            /*Context context = getApplicationContext();
            CharSequence text = "Wrong Info Please Correct";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();*/
        }

    }
    protected boolean vote_checker()//return false by checking in the database whether the person has already voted or not
    {
        boolean b = false;

        return b;
    }
    protected boolean identity_checker()
    {
        boolean b= false;
        String aadhar = aadhar_no.getText().toString();
        String area = area_code.getText().toString();
        String mob = mob_no.getText().toString();
        Login_Validator Login_Validator = new Login_Validator(this);
        Login_Validator.execute(aadhar,area,mob);
        b=Login_Validator.returner();
        return b;
    }
}
