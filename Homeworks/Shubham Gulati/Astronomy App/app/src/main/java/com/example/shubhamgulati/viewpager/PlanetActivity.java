package com.example.shubhamgulati.viewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlanetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);
        Planet planet = getIntent().getParcelableExtra("object");
        TextView Tv_ActivityPlanet = findViewById(R.id.Tv_ActivityPlanet);
        Tv_ActivityPlanet.setText(planet.getPname());
        ImageView Iv_ActivityPlanet = findViewById(R.id.Iv_ActivityPlanet);
        Picasso.get().load(planet.getPuri()).fit().placeholder(R.drawable.ic_launcher_background).into(Iv_ActivityPlanet);
        TextView Tv2_ActivityPlanet = findViewById(R.id.Tv2_ActivityPlanet);
        Tv2_ActivityPlanet.setText(planet.getPbio());


    }
}
