package com.example.shubhamgulati.githubapi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Main2Activity extends Activity {
    TextView tv;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        APIResponse apiResponse = getIntent().getParcelableExtra("object");
//        ArrayList<Users> usersArrayList = apiResponse.getItems();
        Users user = getIntent().getParcelableExtra("object");
        tv= findViewById(R.id.tv);
        iv = findViewById(R.id.iv);
        tv.setText(user.getLogin());
        Log.e("TAG",user.getLogin());
        Picasso.get().load(user.getAvatar_url()).placeholder(R.drawable.ic_launcher_background).fit().into(iv);
    }
}
