package com.example.shubhamgulati.viewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class GalaxyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galaxy);
        Galaxy galaxy = getIntent().getParcelableExtra("object");
        TextView Tv_ActivityGalaxy = findViewById(R.id.Tv_ActivityGalaxy);
        Tv_ActivityGalaxy.setText(galaxy.getGname());
        ImageView Iv_ActivityGalaxy = findViewById(R.id.Iv_ActivityGalaxy);
        Picasso.get().load(galaxy.getGuri()).fit().placeholder(R.drawable.ic_launcher_background).into(Iv_ActivityGalaxy);
        TextView Tv2_ActivityGalaxy = findViewById(R.id.Tv2_ActivityGalaxy);
        Tv2_ActivityGalaxy.setText(galaxy.getGbio());
    }
}
