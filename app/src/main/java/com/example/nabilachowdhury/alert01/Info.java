package com.example.nabilachowdhury.alert01;

import android.os.Parcel;
import android.os.Parcelable;

public class Info implements Parcelable{

    public String name;
    public String height;
    public String weight;




    public Info(String name, String height, String weight) {
        this.name = name;
        this.height = height;
        this.weight= weight;
    }

    public Info(Parcel in){
        String[] data = new String[3];
        in.readStringArray(data);
        this.name = data[0];
        this.height = data[1];
        this.weight = data[2];
    }


    public static final Creator<Info> CREATOR = new Creator<Info>() {
        @Override
        public Info createFromParcel(Parcel in) {
            return new Info(in);
        }

        @Override
        public Info[] newArray(int size) {
            return new Info[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.name, this.height, this.weight});
    }
}

