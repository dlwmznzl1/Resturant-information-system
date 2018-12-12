package com.hsc.ghfwm.food;


import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.sql.Date;

public class Main2Activity extends AppCompatActivity
{
    EditText etname,ettel,etmenu1,etmenu2,etmenu3,etmenu4;
    RadioButton rb1,rb2,rb3;
    rest res;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etname = (EditText)findViewById(R.id.etname);
        ettel = (EditText)findViewById(R.id.ettel);
        etmenu1 = (EditText)findViewById(R.id.etmenu1);
        etmenu2 = (EditText)findViewById(R.id.etmenu2);
        etmenu3 = (EditText)findViewById(R.id.etmenu3);
        etmenu4 = (EditText)findViewById(R.id.etmenu4);
        rb1 = (RadioButton)findViewById(R.id.radio1);
        rb2 = (RadioButton)findViewById(R.id.radio2);
        rb3 = (RadioButton)findViewById(R.id.radio3);
        setTitle("새로운 맛집");

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v)
    {
        if (v.getId() == R.id.btnCancel)
        {
            finish();
        }
        else
        {
            if(rb1.isChecked())
            {
                setcategory(1);
            }
            else if (rb2.isChecked())
            {
                setcategory(2);
            }
            else if (rb3.isChecked())
            {
                setcategory(3);
            }
            res.setMenu(etmenu1.getText().toString());
            res.setMenu(etmenu2.getText().toString());
            res.setMenu(etmenu3.getText().toString());
            res.setMenu(etmenu4.getText().toString());
            res.setDate(finddate());
            Intent intent = getIntent();
            intent.putExtra("새로운 맛집",res);
            setResult(RESULT_OK,intent);
            finish();
        }
    }

    public void setcategory(int n)
    {
        res = new rest(etname.getText().toString(), ettel.getText().toString(),n);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String finddate()
    {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fmdate = sdf.format(date);
        return fmdate;
    }

}
