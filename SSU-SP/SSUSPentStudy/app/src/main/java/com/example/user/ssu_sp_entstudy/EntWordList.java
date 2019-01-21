package com.example.user.ssu_sp_entstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EntWordList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entword_list);
    }

    public void onButtonBackButton(View v){
        finish();
    }
}//classe end
