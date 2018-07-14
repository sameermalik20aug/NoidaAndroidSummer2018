package com.example.shubhamgulati.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Planet implements Parcelable{
    private String Pname;
    private int Puri;
    private String Pbio;

    public Planet(String pname, int puri, String pbio) {
        Pname = pname;
        Puri = puri;
        Pbio = pbio;
    }

    protected Planet(Parcel in) {
        Pname = in.readString();
        Puri = in.readInt();
        Pbio = in.readString();
    }

    public static final Creator<Planet> CREATOR = new Creator<Planet>() {
        @Override
        public Planet createFromParcel(Parcel in) {
            return new Planet(in);
        }

        @Override
        public Planet[] newArray(int size) {
            return new Planet[size];
        }
    };

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public int getPuri() {
        return Puri;
    }

    public void setPuri(int puri) {
        Puri = puri;
    }

    public String getPbio() {
        return Pbio;
    }

    public void setPbio(String pbio) {
        Pbio = pbio;
    }
    public static ArrayList<Planet> getPlanet(){
        ArrayList<Planet> planetArrayList = new ArrayList<>();
          planetArrayList.add(new Planet("Mercury",R.drawable.mercury,"Mercury is the smallest and innermost planet in the Solar System"));
          planetArrayList.add(new Planet("Venus",R.drawable.venus,"Venus is the second planet from the Sun, orbiting it every 224.7 Earth days."));
          planetArrayList.add(new Planet("Earth",R.drawable.earth,"Earth is the third planet from the Sun and the only astronomical object known to harbor life."));
          planetArrayList.add(new Planet("Mars",R.drawable.mars,"Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury."));
          planetArrayList.add(new Planet("Jupiter",R.drawable.jupiter,"Jupiter is the fifth planet from the Sun and the largest in the Solar System."));
          planetArrayList.add(new Planet("Saturn",R.drawable.saturn,"Saturn is the sixth planet from the Sun and the second-largest in the Solar System, after Jupiter."));
          planetArrayList.add(new Planet("Uranus",R.drawable.uranus,"Uranus is the seventh planet from the Sun. It has the third-largest planetary radius and fourth-largest planetary mass in the Solar System."));
          planetArrayList.add(new Planet("Neptune",R.drawable.neptune,"Neptune is the eighth and farthest known planet from the Sun in the Solar System. In the Solar System, it is the fourth-largest planet by diameter, the third-most-massive planet, and the densest giant planet."));


        return planetArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Pname);
        dest.writeInt(Puri);
        dest.writeString(Pbio);
    }

}
