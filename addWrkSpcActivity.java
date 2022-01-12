package com.app.nooted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.app.nooted.Resource.DatabaseHelper;
import com.app.nooted.Resource.User;

public class addWrkSpcActivity extends AppCompatActivity {

    private Button createBttn;
    private Button backBttn;
    private EditText editTextWSName;

    private ImageView imageViewYellow;
    private ImageView imageViewRoyalBlue;
    private ImageView imageViewLightBlue;
    private ImageView imageViewPink;
    private Intent wsIntent;
    private DatabaseHelper DB;
    private String bgColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wrk_spc);

        editTextWSName = (EditText) findViewById(R.id.editTextCardName);


        DB = new DatabaseHelper(this);
        User new_user = DB.getUser(1); // 1 ??


        imageViewLightBlue=(ImageView) findViewById(R.id.imageViewLightBlue);
        imageViewRoyalBlue=(ImageView) findViewById(R.id.imageViewRoyalBlue);
        imageViewPink=(ImageView) findViewById(R.id.imageViewPink);
        imageViewYellow=(ImageView) findViewById(R.id.imageViewYellow);

        wsIntent = new Intent(addWrkSpcActivity.this, mainmenuActivity.class);

        imageViewYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgColor= "lYellow";
            }
        });
        imageViewRoyalBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgColor= "RoyalBlue";
            }
        });
        imageViewPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgColor= "Pink";
            }
        });
        imageViewLightBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgColor = "lBlue";

            }
        });

        createBttn = (Button)findViewById(R.id.createBttn);
        backBttn = (Button) findViewById(R.id.backBttn);

        createBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB.InsertWorkSpace(new_user.getWorkSpaceId(),editTextWSName.getText().toString(),bgColor);
                finish();
            }
        });

        backBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}