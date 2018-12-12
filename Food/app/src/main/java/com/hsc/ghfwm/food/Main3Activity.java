package com.hsc.ghfwm.food;



import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class Main3Activity extends AppCompatActivity
{
    TextView name, menu1,menu2,menu3,menu4,tvtel,tvdate;
    ImageView imageView;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("맛집 정보");
        name = (TextView)findViewById(R.id.txtname);
        menu1 = (TextView)findViewById(R.id.etmenu1);
        menu2 = (TextView)findViewById(R.id.etmenu2);
        menu3 = (TextView)findViewById(R.id.etmenu3);
        menu4 = (TextView)findViewById(R.id.etmenu4);
        tvtel = (TextView)findViewById(R.id.tvTel);
        tvdate = (TextView)findViewById(R.id.tvRegdate);
        back = (Button)findViewById(R.id.btnback) ;
        imageView = (ImageView)findViewById(R.id.imgno);
        Intent intent = getIntent();
        rest res = intent.getParcelableExtra("맛집 정보");

        name.setText(res.getName());
        menu1.setText(res.getmenu1());
        menu2.setText(res.getmenu2());
        menu3.setText(res.getmenu3());
        menu4.setText(res.getmenu4());
        tvtel.setText(res.getTel());
        tvdate.setText(res.getDate());
        if(res.getCategorynum() == 1)
        {
            imageView.setImageResource(R.drawable.noddle);
        }
        else if (res.getCategorynum() == 2)
        {
            imageView.setImageResource(R.drawable.rice);
        }
        else
        {
            imageView.setImageResource(R.drawable.or);
        }
    }

    public void onClick(View v)
    {
        Intent intent = getIntent();
        rest res = intent.getParcelableExtra("맛집 정보");
        switch (v.getId())
        {
            case R.id.btnback:
                finish();
                break;
            case R.id.imageView2:
                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("전화번호:/"+res.getTel()));
                startActivity(intent2);
                break;

        }
    }
}