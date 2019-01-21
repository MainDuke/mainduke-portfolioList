package com.example.user.ssu_sp_entstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.ssu_sp_entstudy.connetor_entStduyList.EntStudyList;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }

    public void onButtonEntList(View v){
        Intent intent = new Intent(getApplicationContext(),EntStudyList.class );
        startActivity(intent);
    }

    public void onButtonEntWordList(View v){
        Intent intent = new Intent(getApplicationContext(),EntWordList.class );
        startActivity(intent);
    }

    public void onButtonEntRecordList(View v){
        Intent intent = new Intent(getApplicationContext(),EntRecordList.class );
        startActivity(intent);
    }

}
