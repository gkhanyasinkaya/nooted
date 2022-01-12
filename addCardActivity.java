package com.app.nooted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addCardActivity extends AppCompatActivity {

    private Button createBttnCard;
    private Button backBttnCard;


    private EditText editTextCardName;
    private EditText editTextPosX;
    private EditText editTextPosY;

    private Intent addCardIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        backBttnCard = (Button) findViewById(R.id.backBttnCardSttng);
        createBttnCard = (Button) findViewById(R.id.setBttnCardSttng);

        editTextPosX = (EditText) findViewById(R.id.editTextAddPosX);
        editTextPosY = (EditText) findViewById(R.id.editTextAddPosY);
        editTextCardName = (EditText) findViewById(R.id.editTextCardName);


        createBttnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCardIntent = new Intent(addCardActivity.this,cardActivity.class);
                addCardIntent.putExtra("posX",editTextPosX.getText());
                addCardIntent.putExtra("posY",editTextPosY.getText());

                //update db
                finish();
            }
        });


        backBttnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}