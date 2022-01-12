package com.app.nooted;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.nooted.Resource.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private EditText editTextPass;

    private Button lgnBttn;
    private TextView signText;
    private Intent intentMain;

    public DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB = new DatabaseHelper(this);

        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPass = findViewById(R.id.editTextPass);

        lgnBttn = findViewById(R.id.lgnBttn);
        signText = findViewById(R.id.signText);

        // LOG IN
        lgnBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check db
                if(DB.CheckLogin(editTextUserName.getText().toString(),editTextPass.getText().toString()) == 1){
                    intentMain = new Intent(MainActivity.this, mainmenuActivity.class);
                    intentMain.putExtra("userID",1);
                    startActivity(intentMain);
                }else{
                    Toast.makeText(MainActivity.this, "Wrong Username or Password!",Toast.LENGTH_LONG).show();
                }

            }
        });

        // SIGN UP
        signText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentMain = new Intent(MainActivity.this, signupActivity.class);
                startActivity(intentMain);
            }
        });

    }
}