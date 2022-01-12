package com.app.nooted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.nooted.Resource.DatabaseHelper;
import com.app.nooted.Resource.DatabaseHelper;
import com.app.nooted.Resource.User;

public class signupActivity extends AppCompatActivity {

    private EditText editTextUserNameReg;
    private EditText editTextPassReg;

    private Button sgnBttn;
    private TextView backText;
    private Intent intentSgn;
    private EditText editTextMail;
    private User new_user;

    private int user_count = 0;
    private DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        DB = new DatabaseHelper(this);

        editTextMail = (EditText)findViewById(R.id.editTextMail);
        editTextUserNameReg = (EditText) findViewById(R.id.editTextUserNameReg);
        editTextPassReg = (EditText) findViewById(R.id.editTextPassReg);
        sgnBttn = (Button) findViewById(R.id.signBttn);
        backText = (TextView) findViewById(R.id.goBackText);

        // GO MAIN
        sgnBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DB.CheckUsername(editTextUserNameReg.getText().toString())){
                    user_count++;
                    new_user = new User(user_count,user_count,editTextUserNameReg.getText().toString(),editTextMail.getText().toString(),editTextPassReg.getText().toString());

                    DB.InsertID(new_user.getId(),new_user.getId(),new_user.getId(),new_user.getId());
                    DB.InsertUser(new_user.getUserName(),new_user.getUserPass(),new_user.getUserMail());
                }else{
                    Toast.makeText(signupActivity.this, "Username already taken!",Toast.LENGTH_LONG).show();
                }
                finish();
            }
        });

        // GO BACK
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}