package com.example.shubhamgulati.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Galaxy implements Parcelable{
    private String Gname;
    private int Guri;
    private  String Gbio;

    protected Galaxy(Parcel in) {
        Gname = in.readString();
        Guri = in.readInt();
        Gbio = in.readString();
    }

    public static final Creator<Galaxy> CREATOR = new Creator<Galaxy>() {
        @Override
        public Galaxy createFromParcel(Parcel in) {
            return new Galaxy(in);
        }

        @Override
        public Galaxy[] newArray(int size) {
            return new Galaxy[size];
        }
    };

    public String getGname() {
        return Gname;
    }

    public void setGname(String gname) {
        Gname = gname;
    }

    public int getGuri() {
        return Guri;
    }

    public void setGuri(int guri) {
        Guri = guri;
    }

    public String getGbio() {
        return Gbio;
    }

    public void setGbio(String gbio) {
        Gbio = gbio;
    }

    public Galaxy(String gname, int guri, String gbio) {

        Gname = gname;
        Guri = guri;
        Gbio = gbio;
    }
     public  static ArrayList<Galaxy> getGalaxy(){
        ArrayList<Galaxy> galaxyArrayList = new ArrayList<>();
        galaxyArrayList.add(new Galaxy("Milky Way",R.drawable.milkyway,"The Milky Way is the galaxy that contains our Solar System."));
        return galaxyArrayList;

     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Gname);
        dest.writeInt(Guri);
        dest.writeString(Gbio);
    }
}
