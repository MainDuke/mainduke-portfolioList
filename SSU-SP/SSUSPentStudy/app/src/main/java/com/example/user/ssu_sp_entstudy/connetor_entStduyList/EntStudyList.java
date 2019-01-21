package com.example.user.ssu_sp_entstudy.connetor_entStduyList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.ssu_sp_entstudy.EntStudy;
import com.example.user.ssu_sp_entstudy.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EntStudyList extends AppCompatActivity {

    ListView listView;
    EntListAdapter entListAdapter;
    ArrayList<EntListItem> list_itemArrayList;
    List<EntStudyList_Property> entStudyList;

    private Retrofit retrofit;
    private final String BASE_URL = "http://e1d0e987.ngrok.io"; //교체 요망

    public void init() {
        //textView = (TextView) findViewById(R.id.textView);
        // GSON 컨버터를 사용하는 REST 어댑터 생성
        //리스트뷰 연결
        listView = (ListView)findViewById(R.id.EntStudy_listview);

        list_itemArrayList = new ArrayList<EntListItem>();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ent_study_list);
        init();




        //HTTP 연결 한다.

        // API 인터페이스 생성
        EntStudyList_interface entStudyList_interface = retrofit.create(EntStudyList_interface.class);

        // 인터페이스에 구현한 메소드에 param 값을 넘기는 요청 만듬
        Call<List<EntStudyList_Property>> call = entStudyList_interface.serverPageBinder("entMainList");
        // 앞서만든 요청을 수행
        call.enqueue(new Callback<List<EntStudyList_Property>>() {
            @Override
            // 성공시
            public void onResponse(Call<List<EntStudyList_Property>> call, Response<List<EntStudyList_Property>> response) {

                entStudyList = response.body();
                // 받아온 리스트를 순회하면서
            if(entStudyList != null) {


                for (EntStudyList_Property entStudyList_Property : entStudyList) {

                    list_itemArrayList.add(new EntListItem(entStudyList_Property.entId, entStudyList_Property.entTitle, entStudyList_Property.entCreateDate, entStudyList_Property.entEditDate,entStudyList_Property.entWriter, entStudyList_Property.entLabel, entStudyList_Property.entTemptext));

//                    Log.d("EntStudyList",entStudyList_Property.entTitle);
//                    if(entStudyList_Property.entTitle instanceof String) {
//                        Log.d("incetanceof 테스트한다. ", entStudyList_Property.entTitle);
//                    }
                }
            }else { Toast.makeText(EntStudyList.this, "entStudyList Null", Toast.LENGTH_LONG)
                    .show();}

                entListAdapter = new EntListAdapter(EntStudyList.this, list_itemArrayList);
                listView.setAdapter(entListAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //Toast는 다음과 같은 파라미터를 요구합니다.
                        //어떤 스크린에 보여줄것인지를 알기위해 context를
                        //어떠한 문자를 출력할것인지를 넣는 char text->이부분은 String을 넣으시면됩니다.
                        //int duration은 지속시간을 나타내는 파라미터입니다.
                        //1000이 1초 인 밀리세컨드 단위로 되어있습니다.
                        //보통 Toast 에 static으로 선언되어있는
                        //Toast.LENGTH_LONG 이나 Toast.LENGTH_SHORT을 입력하는것이 대부분입니다.

                        //Toast.makeText(EntStudyList.this ,list_itemArrayList.get(position).getListview_entWriter(),Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(),EntStudy.class );
                        intent.putExtra("entId",list_itemArrayList.get(position).getEntId());
                        intent.putExtra("entTitle",list_itemArrayList.get(position).getEntTitle());
                        intent.putExtra("entLabel",list_itemArrayList.get(position).getEntLabel());
                        intent.putExtra("entCreateDate",list_itemArrayList.get(position).getEntCreateDate());
                        intent.putExtra("entEditDate",list_itemArrayList.get(position).getEntEditDate());
                        intent.putExtra("entWriter",list_itemArrayList.get(position).getEntWriter());
                        intent.putExtra("entTemptext",list_itemArrayList.get(position).getEntTemptext());

                        startActivity(intent);

                    }
                });


            }

            @Override
            // 실패시
            public void onFailure(Call<List<EntStudyList_Property>> call, Throwable t) {
                Toast.makeText(EntStudyList.this, "정보받아오기 실패", Toast.LENGTH_LONG)
                        .show();
            }
        });

        //어탭터 연결
//        entListAdapter = new EntListAdapter(EntStudyList.this, list_itemArrayList);
//        listView.setAdapter(entListAdapter);

        //onClick Listener 추가
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast는 다음과 같은 파라미터를 요구합니다.
                //어떤 스크린에 보여줄것인지를 알기위해 context를
                //어떠한 문자를 출력할것인지를 넣는 char text->이부분은 String을 넣으시면됩니다.
                //int duration은 지속시간을 나타내는 파라미터입니다.
                //1000이 1초 인 밀리세컨드 단위로 되어있습니다.
                //보통 Toast 에 static으로 선언되어있는
                //Toast.LENGTH_LONG 이나 Toast.LENGTH_SHORT을 입력하는것이 대부분입니다.

                //Toast.makeText(EntStudyList.this ,list_itemArrayList.get(position).getListview_entWriter(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(),EntStudy.class );
                intent.putExtra("entId",list_itemArrayList.get(position).getEntId());
                startActivity(intent);

            }
        });
    }
}
