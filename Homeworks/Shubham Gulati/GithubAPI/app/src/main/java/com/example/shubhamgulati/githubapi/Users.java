package com.example.shubhamgulati.githubapi;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable {
    private String login , avatar_url , html_url;

    protected Users(Parcel in) {
        login = in.readString();
        avatar_url = in.readString();
        html_url = in.readString();
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(avatar_url);
        dest.writeString(html_url);
    }
}
