package com.app.nooted.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.nooted.R;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.app.nooted.cardActivity;


import java.util.ArrayList;

public class firstFragment extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ArrayList<String> deneme_array1;
    private Boolean isCreated;
    private ImageButton addButtonFrg1;
    private ImageButton imageButtonFrg1;
    private EditText editTextFrg1;
    private Intent intentFrg1;


    private String Color;
    public int secFragPosX = 0; //database
    public int secFragPosY = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_first, container, false);
        return view1;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        deneme_array1 = new ArrayList<String>();
        isCreated = true;

        deneme_array1.add("a");
        deneme_array1.add("v");

        view.findViewById(R.id.textViewFrg1).setVisibility(View.INVISIBLE);
        view.findViewById(R.id.imageButtonFrg1).setVisibility(View.INVISIBLE);

        if(isCreated) {
            view.findViewById(R.id.textViewFrg1).setVisibility(View.VISIBLE);
            view.findViewById(R.id.imageButtonFrg1).setVisibility(View.VISIBLE);

            ListView listViewFrg1 = (ListView) view.findViewById(R.id.listViewFrg1);
            ArrayAdapter<String> adapterFrg1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, deneme_array1);
            listViewFrg1.setAdapter(adapterFrg1);

            listViewFrg1.setOnItemClickListener(this);
            listViewFrg1.setOnItemLongClickListener(this);
        }

        addButtonFrg1 = (ImageButton) view.findViewById(R.id.addButtonFrg1);
        editTextFrg1 = (EditText) view.findViewById(R.id.editTextFrg1);

        addButtonFrg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deneme_array1.add(editTextFrg1.getText().toString());
                editTextFrg1.setText("");
            }
        });

        imageButtonFrg1 = (ImageButton) view.findViewById(R.id.imageButtonFrg1);

        imageButtonFrg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentFrg1 = new Intent(getActivity(), cardActivity.class);
                /*intent2.putExtra("secFragPosX",0); //database
                intent2.putExtra("secFragPosY",1);
                intent2.putExtra("secFragcardName","Deneme");*/
                startActivity(intentFrg1);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        gotoFragment();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        gotoSettings();
        return false;
    }

    public void gotoFragment(){
        intentFrg1 = new Intent(getActivity(), cardActivity.class);
        intentFrg1.putExtra("isClicked",true);
        intentFrg1.putExtra("whFrag","secondFragment");
        startActivity(intentFrg1);
    }

    public void gotoSettings(){
        intentFrg1 = new Intent(getActivity(), cardActivity.class);
        startActivity(intentFrg1);
    }

}