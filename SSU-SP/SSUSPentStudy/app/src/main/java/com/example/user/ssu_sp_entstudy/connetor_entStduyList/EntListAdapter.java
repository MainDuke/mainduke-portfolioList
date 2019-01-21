package com.example.user.ssu_sp_entstudy.connetor_entStduyList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.ssu_sp_entstudy.R;

import java.util.ArrayList;

public class EntListAdapter extends BaseAdapter {

    Context context;
    ArrayList<EntListItem> list_itemArrayList;


    TextView listview_entId;
    TextView listview_entTitle;
    TextView listview_entWriter;
    TextView listview_entDate;


    public EntListAdapter(Context context, ArrayList<EntListItem> list_itemArrayList) {
        this.context = context;
        this.list_itemArrayList = list_itemArrayList;
    }

    @Override
    public int getCount() {
        return this.list_itemArrayList.size();
    }


    //    int getCount()는 이 리스트뷰가 몇개의 아이템을 가지고있는지를 알려주는 함수입니다.
    //    우리는 arraylist의 size(갯수) 만큼 가지고있으므로
    //    return 0 ; ->      this.list_itemArrayList.size();


    @Override
    public Object getItem(int position) {
        return this.list_itemArrayList.get(position);
    }

    // Object getItem(int position)은 현재 어떤 아이템인지를 알려주는 부분으로 우리는 arraylist에 저장되있는 객체중 position에 해당하는것을 가져올것이므로
    // return null; ->return this.list_itemArrayList.get(position)으로 변경합니다.


    @Override
    public long getItemId(int position) {
        return position;
    }

    // 은 현재 어떤 포지션인지를 알려주는 부분으로
    // return 0; -> return postion으로 변경합니다


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.entstudy_listview_item,null);

            listview_entId = (TextView)convertView.findViewById(R.id.Textview_entTemptext);
            listview_entTitle = (TextView)convertView.findViewById(R.id.listview_entTitle);
            listview_entWriter = (TextView)convertView.findViewById(R.id.listview_entWriter);
            listview_entDate  =(TextView)convertView.findViewById(R.id.listview_entDate);

        }

        listview_entId.setText(list_itemArrayList.get(position).getEntId());
        listview_entTitle.setText(list_itemArrayList.get(position).getEntTitle());
        listview_entWriter.setText(list_itemArrayList.get(position).getEntWriter());
        listview_entDate.setText(list_itemArrayList.get(position).getEntCreateDate());

        return convertView;
    }


    //    이 부분이 리스트뷰에서 아이템과 xml을 연결하여 화면에 표시해주는
    //    가장 중요한 부분입니다. getView부분에서 반복문이 실행된다고 이해하시면 편하며 순차적으로 한칸씩 화면을 구성해주는 부분입니다.
    //    (여기서 부터는 이해가 가지않으시면 패턴을 암기하시면됩니다.)
    //
    //    우선 convertView라는 파라미터를 메소드에서 주는데요 이 부분에 우리가 만든 item.xml을 불러와야합니다. 여기는 엑티비티가 아니므로 불러오기위한 약간의 절차가 필요한데요 그 때문에 위에서 저희가 Context를 생성자를 통해 받은것입니다.
    //    LayoutInflater 클래스를 이용하면 다른 클래스에서도 xml을 가져올수있는데요
    //    LayoutInflater.from(context).inflate("레이아웃.xml",null);
    //    하면 View 클래스를 리턴해줍니다.

}
