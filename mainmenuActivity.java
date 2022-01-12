package com.app.nooted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.app.nooted.Resource.DatabaseHelper;
import com.app.nooted.Resource.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class mainmenuActivity extends AppCompatActivity {

    private ListView customListView;
    private FloatingActionButton addWrkSpcBttn;
    private Intent intentMenu;
    private DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        /*DB = new DatabaseHelper(this);
        User new_user = DB.getUser(1); // 1 ??*/

        ArrayList<String> list_elements = new ArrayList<>();

        list_elements.add("a");
        list_elements.add("b");

        customListView = (ListView) findViewById(R.id.customListView);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, list_elements);
        customListView.setAdapter(adapter2);

        // ADD WORKSPACE
        addWrkSpcBttn = (FloatingActionButton) findViewById(R.id.addWrkSpcBttn);
        addWrkSpcBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentMenu = new Intent(mainmenuActivity.this, addWrkSpcActivity.class);
                startActivity(intentMenu);
            }
        });

        // GO TO WORKSPACE
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intentMenu = new Intent(mainmenuActivity.this, cardActivity.class);
                intentMenu.putExtra("whichElement",i);
                startActivity(intentMenu);
            }
        });
    }
}