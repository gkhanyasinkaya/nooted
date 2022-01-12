package com.app.nooted;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class elementSettings extends AppCompatActivity {

    private EditText editTextElementName;
    private EditText editTextElementPos;
    private EditText editTextDesc;

    private String elementName;
    private String elementPos;
    private String elementDesc;

    private Button setBttnElementSttngs;
    private Button elementBackBttn;
    private Button elementDelBttn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_settings);

        elementName = "alıntı";
        elementPos = "0";

        editTextDesc = (EditText) findViewById(R.id.editTextDesc);
        editTextElementName = (EditText) findViewById(R.id.editTextElementName);
        editTextElementPos = (EditText) findViewById(R.id.editTextElementPos);

        editTextElementName.setHint(elementName);
        editTextElementPos.setHint(elementPos);

        setBttnElementSttngs = (Button) findViewById(R.id.setBttnElementSttngs);
        elementBackBttn = (Button) findViewById(R.id.elementBackBttn);
        elementDelBttn = (Button) findViewById(R.id.elementDelBttn);

        setBttnElementSttngs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //db update
                finish();
            }
        });

        elementBackBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        elementDelBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update db
                finish();
            }
        });



    }
}