package com.example.demo14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BActivity extends AppCompatActivity {
    TextView usertext, userEmail, userMob, userPass ;
    String txtname, txtEmail, txtMob, txtPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bactivity);

        usertext = findViewById(R.id.txtUname);
        txtname = getIntent().getStringExtra("uname");
        usertext.setText(""+txtname);

        userEmail = findViewById(R.id.txtEmail);
        txtEmail = getIntent().getStringExtra("emailid");
        userEmail.setText(""+txtEmail);

        userMob = findViewById(R.id.txtMobile);
        txtMob = getIntent().getStringExtra("mobnum");
        userMob.setText(""+txtMob);

        userPass = findViewById(R.id.txtPass);
        txtPass = getIntent().getStringExtra("password");
        userPass.setText(""+txtPass);




    }

    public void onBackBtn(View view) {

        startActivity(new Intent(BActivity.this,MainActivity.class));
        finish();
    }
}