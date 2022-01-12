package com.app.nooted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class cardActivity extends AppCompatActivity {

    private FloatingActionButton addBttnCard;
    private Intent intentCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        addBttnCard = (FloatingActionButton) findViewById(R.id.addBttnCard);
        addBttnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCard = new Intent(cardActivity.this,addCardActivity.class);
                startActivity(intentCard);
            }
        });
    }
}