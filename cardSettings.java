package com.app.nooted;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class cardSettings extends AppCompatActivity {

    private String posX;
    private String posY;
    private String cardName;

    private EditText editTextCardNameSttng;
    private EditText editTextPosXSttng;
    private EditText editTextPosYSttng;

    private Button setBttnCardSttng;
    private Button backBttnCardSttng;
    private Button cardDelBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_settings);

        editTextCardNameSttng = (EditText) findViewById(R.id.editTextCardName);
        editTextPosXSttng = (EditText) findViewById(R.id.editTextAddPosX);
        editTextPosYSttng = (EditText) findViewById(R.id.editTextAddPosY);

        //db
        posX = "0";
        posY = "1";
        cardName = "Deneme";

        editTextCardNameSttng.setHint(cardName);
        editTextPosXSttng.setHint(posX);
        editTextPosYSttng.setHint(posY);


        setBttnCardSttng = (Button) findViewById(R.id.setBttnCardSttng);
        backBttnCardSttng = (Button) findViewById(R.id.backBttnCardSttng);
        cardDelBttn = (Button) findViewById(R.id.cardDelBttn);

        setBttnCardSttng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update db
                finish();
            }
        });

        backBttnCardSttng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cardDelBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // db update
                finish();
            }
        });


    }
}