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
import com.app.nooted.cardSettings;
import com.app.nooted.elementSettings;
import com.app.nooted.cardInnerActivity;

import java.util.ArrayList;

public class secondFragment extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {


    private Boolean isCreated;
    private ImageButton addButtonFrg2;
    private ImageButton imageButtonFrg2;
    private EditText editTextFrg2;

    private Intent intentFrg2;

    //DATA
    private ArrayList<String> deneme_array2;
    private String Color;
    public int secFragPosX = 0; //database
    public int secFragPosY = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.fragment_second, container, false);
        return view2;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        deneme_array2 = new ArrayList<String>();
        isCreated = true;

        deneme_array2.add("a");

        view.findViewById(R.id.textViewCreateCard).setVisibility(View.INVISIBLE);
        view.findViewById(R.id.imageButtonFrg2).setVisibility(View.INVISIBLE);

        if(isCreated) {
            view.findViewById(R.id.textViewCreateCard).setVisibility(View.VISIBLE);
            view.findViewById(R.id.imageButtonFrg2).setVisibility(View.VISIBLE);

            ListView listViewFrg2 = (ListView) view.findViewById(R.id.listViewFrg2);
            ArrayAdapter<String> adapterFrg2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, deneme_array2);
            listViewFrg2.setAdapter(adapterFrg2);

            listViewFrg2.setOnItemClickListener(this);
            listViewFrg2.setOnItemLongClickListener(this);
        }

        addButtonFrg2 = (ImageButton) view.findViewById(R.id.addButtonFrg2);
        editTextFrg2 = (EditText) view.findViewById(R.id.editTextFrg2);

        addButtonFrg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deneme_array2.add(editTextFrg2.getText().toString());
                editTextFrg2.setText("");
            }
        });

        imageButtonFrg2 = (ImageButton) view.findViewById(R.id.imageButtonFrg2);

        imageButtonFrg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentFrg2 = new Intent(getActivity(), cardSettings.class);
                startActivity(intentFrg2);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        gotoFragment();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        gotoElementSettings();
        return false;
    }

    public void gotoFragment(){
        intentFrg2 = new Intent(getActivity(), cardInnerActivity.class);
        intentFrg2.putExtra("isClicked",true);
        intentFrg2.putExtra("whFrag","secondFragment");
        startActivity(intentFrg2);
    }

    public void gotoElementSettings(){
        intentFrg2 = new Intent(getActivity(), elementSettings.class);
        startActivity(intentFrg2);
    }

}