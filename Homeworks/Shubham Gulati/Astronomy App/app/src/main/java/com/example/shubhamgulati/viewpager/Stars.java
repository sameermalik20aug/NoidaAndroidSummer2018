package com.example.shubhamgulati.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Stars implements Parcelable {
    private String Sname;
    private int Surl;
    private String Sbio;

    public Stars(String sname, int surl, String sbio) {
        Sname = sname;
        Surl = surl;
        Sbio = sbio;
    }

    protected Stars(Parcel in) {
        Sname = in.readString();
        Surl = in.readInt();
        Sbio = in.readString();
    }

    public static final Creator<Stars> CREATOR = new Creator<Stars>() {
        @Override
        public Stars createFromParcel(Parcel in) {
            return new Stars(in);
        }

        @Override
        public Stars[] newArray(int size) {
            return new Stars[size];
        }
    };

    public String getSname() {
        return Sname;
    }

    public int getSurl() {
        return Surl;
    }

    public String getSbio() {
        return Sbio;
    }
    public static ArrayList<Stars> getStars(){
        ArrayList<Stars> starsArrayList = new ArrayList<>();
          starsArrayList.add(new Stars("Sirius",R.drawable.sirius,"Sirius is a star system and the brightest star in the Earth's night sky."));
          starsArrayList.add(new Stars("Betelgeuse",R.drawable.betelgeuse,"Betelgeuse is the  ninth-brightest star in the night sky and second-brightest in the constellation of Orion."));
//        starsArrayList.add(new Stars("Vega",,"Vega is the brightest star in the constellation of Lyra, the fifth-brightest star in the night sky, and the second-brightest star in the northern celestial hemisphere, after Arcturus."));
//        starsArrayList.add(new Stars("Altair",,"Altair is a star in the Aquila constellation."));
//        starsArrayList.add(new Stars("Arcturus",,"Arcturus is the brightest star in the constellation of Boötes, the fourth-brightest in the night sky, and the brightest in the northern celestial hemisphere."));
//        starsArrayList.add(new Stars("Deneb",,"Deneb is the  brightest star in the constellation of Cygnus."));
 //       starsArrayList.add(new Stars());
 //       starsArrayList.add(new Stars());

        return  starsArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Sname);
        dest.writeInt(Surl);
        dest.writeString(Sbio);
    }
}
