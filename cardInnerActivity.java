package com.app.nooted;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.app.nooted.Fragments.eigthFragment;
import com.app.nooted.Fragments.fifthFragment;
import com.app.nooted.Fragments.firstFragment;
import com.app.nooted.Fragments.fourthFragment;
import com.app.nooted.Fragments.secondFragment;
import com.app.nooted.Fragments.seventhFragment;
import com.app.nooted.Fragments.sixthFragment;
import com.app.nooted.Fragments.thirdFragment;

public class cardInnerActivity extends AppCompatActivity{

    //FragmentContainerView genFragCont;
    private Bundle bundleMng;
    private Intent intentMng;

    private Boolean isClicked;
    private String fragName;

    private FragmentManager fragmentManager;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_inner);

        fragmentManager = getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();

        // Passing data via Bundle (fragment to activity)
        intentMng = getIntent();
        bundleMng = intentMng.getExtras();
        isClicked = bundleMng.getBoolean("isClicked");
        fragName = bundleMng.getString("whFrag");

        // Checking data to open correct fragment
        switch (fragName){
            case "firstFragment":
                ft.replace(R.id.fragContGen,new firstFragment());
                ft.commit();
                break;
            case "secondFragment":
                ft.replace(R.id.fragContGen,new secondFragment());
                ft.commit();
                break;
            case "thirdFragment":
                ft.replace(R.id.fragContGen,new thirdFragment());
                ft.commit();
                break;
            case "fourthFragment":
                ft.replace(R.id.fragContGen,new fourthFragment());
                ft.commit();
                break;
            case "fifthFragment":
                ft.replace(R.id.fragContGen,new fifthFragment());
                ft.commit();
                break;
            case "sixthFragment":
                ft.replace(R.id.fragContGen,new sixthFragment());
                ft.commit();
                break;
            case "seventhFragment":
                ft.replace(R.id.fragContGen,new seventhFragment());
                ft.commit();
                break;
            case "eigthFragment":
                ft.replace(R.id.fragContGen,new eigthFragment());
                ft.commit();
                break;
        }


    }
}