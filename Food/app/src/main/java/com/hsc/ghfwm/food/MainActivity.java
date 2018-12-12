package com.hsc.ghfwm.food;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    ArrayList<String> resturantdata = new ArrayList<String>();
    ArrayAdapter<String> Adapter;
    ArrayList<rest> resturantlist = new ArrayList<rest>();
    ListView listview;
    final int RESTURANT_INFO = 21;
    final int NEW_RESTURANT = 22;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.tv);
        setTitle("맛집 정보");
        setListView();
    }


    public void onClick(View v)
    {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("restlist",resturantdata);
        startActivityForResult(intent,NEW_RESTURANT);
    }
    public void setListView()
    {
        listview = (ListView)findViewById(R.id.list);

        Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,resturantdata);
        listview.setAdapter(Adapter);


        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {


                AlertDialog.Builder dlg = new AlertDialog.Builder(view.getContext());
                dlg.setTitle("삭제 확인")
                        .setIcon(R.drawable.icon2)
                        .setMessage("선택한 맛집정보를 삭제하시겠습니까?")
                        .setNegativeButton("취소",null)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                //삭제 클릭시 아래꺼
                                resturantdata.remove(position);
                                resturantlist.remove(position);
                                Adapter.notifyDataSetChanged();
                                tv.setText("맛집 리스트("+resturantdata.size()+"개)");
                                Snackbar.make(view,"삭제되었습니다.",2000).show();
                            }
                        })
                        .show();
                return true;
            }
        });


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                rest res = resturantlist.get(position);
                intent.putExtra("맛집 정보",res);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == NEW_RESTURANT)
        {
            if(resultCode == RESULT_OK)
            {
                rest res = data.getParcelableExtra("새로운 맛집");
                resturantdata.add(res.getName());
                resturantlist.add(res);
                Adapter.notifyDataSetChanged();
                tv.setText("맛집 리스트("+resturantdata.size()+"개)");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
