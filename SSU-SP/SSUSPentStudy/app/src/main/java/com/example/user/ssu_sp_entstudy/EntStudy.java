package com.example.user.ssu_sp_entstudy;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.ssu_sp_entstudy.connetor_entStduyList.EntStudyList;

import java.util.ArrayList;

public class EntStudy extends AppCompatActivity {

    Intent intent, preIntent;
    SpeechRecognizer mRecognizer;
    TextView textView, anounceTextView,textview_compare,Textview_result,Textview_entTemptext,Textview_ing ;
    private final int MY_PERMISSIONS_RECORD_AUDIO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        preIntent = getIntent();

        Toast.makeText(EntStudy.this, "받아오기 테스트 entId= "+preIntent.getStringExtra("entId"), Toast.LENGTH_LONG)
                .show();

//preIntent.getStringExtra("entId")



        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.RECORD_AUDIO)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO}, MY_PERMISSIONS_RECORD_AUDIO
                );
            }
        }

        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
        intent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);

        mRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        mRecognizer.setRecognitionListener(recognitionListener);


        textView = (TextView) findViewById(R.id.textView);
        anounceTextView = (TextView) findViewById(R.id.anounceTextView);
        textview_compare = (TextView) findViewById(R.id.textview_compare);
        Textview_result= (TextView) findViewById(R.id.Textview_result);
        Textview_entTemptext =(TextView) findViewById(R.id.Textview_entTemptext);
        Textview_ing = (TextView) findViewById(R.id.Textview_ing);

        Button button = (Button) findViewById(R.id.button01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecognizer.startListening(intent);
            }
        });


        Button button2 = (Button) findViewById(R.id.button02);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecognizer.stopListening();
            }
        });

        Textview_entTemptext.setText(preIntent.getStringExtra("entTemptext"));


    }

    private RecognitionListener recognitionListener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle bundle) {

            anounceTextView.setText("onReadyForSpeech");

        }

        @Override
        public void onBeginningOfSpeech() {
            anounceTextView.setText("듣는중");
        }

        @Override
        public void onRmsChanged(float v) {
        }

        @Override
        public void onBufferReceived(byte[] bytes) {
        }

        @Override
        public void onEndOfSpeech() {
            anounceTextView.setText("onEndOfSpeech");
        }

        @Override
        public void onError(int i) {
            Textview_result.setText("너무 늦게 말하면 오류뜹니다");

        }

        @Override
        public void onResults(Bundle bundle) {
            anounceTextView.setText("onResults");
            String key = "";
            key = SpeechRecognizer.RESULTS_RECOGNITION;
            ArrayList<String> mResult = bundle.getStringArrayList(key);

            String[] rs = new String[mResult.size()];
            mResult.toArray(rs);

            Textview_result.setText(rs[0]);
            entCompare(rs[0]);
        }

        @Override
        public void onPartialResults(Bundle bundle) {
//            String key = "";
//            key = SpeechRecognizer.RESULTS_RECOGNITION;
//            ArrayList<String> mResult = bundle.getStringArrayList(key);
//
//            String[] rs = new String[mResult.size()];
//            mResult.toArray(rs);
//
//            Textview_ing.setText(rs[0]);

        }

        @Override
        public void onEvent(int i, Bundle bundle) {
            anounceTextView.setText("onEvent");
        }
    };

    public void entCompare(String sttText){



        int count =0;
        String str1=sttText.toLowerCase();
        String str2=preIntent.getStringExtra("entTemptext").toLowerCase();

        String[] arr1= str1.split(" ");
        String[] arr2= str2.split(" ");
        String result="";

//        SpannableStringBuilder ssb = new SpannableStringBuilder(str);
//        ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#ff0000")), 6, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        tv.setText(ssb);


        Log.d("test str1= ", str1);

        //Textview_result 결과창
        for(int i=0;i<arr1.length;i++){
            if(arr1.length > arr2.length){break;}
            if(arr2[i].equals( arr1[i])){
                result = result + arr1[i];
            }else{
                count++;
                result = result + "-"+arr1[i] + "-";
            }
        }
        //this @is@ real @apple.@

        //@ 찾는다.
        SpannableStringBuilder ssb = new SpannableStringBuilder(result);

        for(int i =0; i < count;i++) {
            ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#ff0000")), result.indexOf("-", 2*i+1  ), result.indexOf("-", 2*i+2 ), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        count=0;
        textview_compare.setText(ssb);

    }//end entCompare


}