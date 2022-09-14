package com.example.demo14;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button submitbtn;
    EditText name_edt, mail_edt, mobile_edt,password_edt;
    String nameStr, mailStr, mobilestr,passstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitbtn = findViewById(R.id.submit_btn);
        name_edt = findViewById(R.id.name_edt);
        mail_edt = findViewById(R.id.mail_edt);
        mobile_edt=findViewById(R.id.mobile_edt);
        password_edt=findViewById(R.id.passwordid);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameStr = name_edt.getText().toString();
                mailStr = mail_edt.getText().toString();
                mobilestr=mobile_edt.getText().toString();
                passstr=password_edt.getText().toString();


                Intent intent = new Intent(MainActivity.this,BActivity.class);
                intent.putExtra("uname",nameStr);
                intent.putExtra("emailid",mailStr);
                intent.putExtra("mobnum",mobilestr);
                intent.putExtra("password",passstr);
                startActivity(intent);

                if (TextUtils.isEmpty(nameStr))
                {
                    name_edt.setError("field cannot be empty");
                }
                else if (TextUtils.isEmpty(mailStr))
                {
                    mailStr.trim().length();
                }else if(!isValidEmailId(mailStr))
                {
                    mail_edt.setError("enter valid mail");
                }
                else if (TextUtils.isEmpty(mobilestr)) {
                    nameStr.trim().length();
                }
                else if (mobilestr.length()<10||mobilestr.length()!=10)
                {
                    mobile_edt.setError("enter 10 digit mobile number");
                }
                else if(!isValidePassword(passstr)){
                    password_edt.setError("Enter valid password");
                }

                else
                {
                    Toast.makeText(MainActivity.this, ""+nameStr+"\n"+mailStr+"\n"+mobilestr+"\n", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidEmailId(String email) {

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1,}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
    public boolean isValidePassword(String password_edt)
    {
        return Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$").matcher(password_edt).matches();

    }

}