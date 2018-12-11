package com.hsc.ghfwm.food;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class rest implements Parcelable
{
    private String name;
    private String telnumber;
    private ArrayList<String> menu;
    private String date;
    private int categorynum;

    public rest(String name, String telnum,  int categorynum)
    {
        this.name = name;
        this.telnumber= telnum;
        this.categorynum = categorynum;
        menu = new ArrayList<String>();
    }


    protected rest(Parcel in) {
        name = in.readString();
        telnumber = in.readString();
        menu = in.createStringArrayList();
        date = in.readString();
        categorynum = in.readInt();
    }

    public static final Creator<rest> CREATOR = new Creator<rest>() {
        @Override
        public rest createFromParcel(Parcel in) {
            return new rest(in);
        }

        @Override
        public rest[] newArray(int size) {
            return new rest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(telnumber);
        dest.writeStringList(menu);
        dest.writeString(date);
        dest.writeInt(categorynum);
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return telnumber;
    }

    public String getmenu1()
    {
        return menu.get(0);
    }
    public String getmenu2()
    {
        return menu.get(1);
    }
    public String getmenu3()
    {
        return menu.get(2);
    }

    public String getDate() {
        return date;
    }

    public int getCategorynum() {
        return categorynum;
    }

    public String printmenu(){
        String str = menu.get(0) + ", " + menu.get(1) + ", " +menu.get(2);
        return str;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String telnum) {
        this.telnumber = telnum;
    }

    public void setMenu(String item) {
        menu.add(item);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategorynum(int categorynum) {
        this.categorynum = categorynum;
    }

}