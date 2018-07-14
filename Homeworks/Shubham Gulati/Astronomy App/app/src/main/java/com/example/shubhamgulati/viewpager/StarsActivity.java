package com.example.shubhamgulati.viewpager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class StarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stars);

        Stars star = getIntent().getParcelableExtra("object");
        TextView Tv_ActivityStar = findViewById(R.id.Tv_ActivityStars);
        Tv_ActivityStar.setText(star.getSname());
        ImageView Iv_ActivityStar = findViewById(R.id.Iv_ActivityStars);
        Picasso.get().load(star.getSurl()).fit().placeholder(R.drawable.ic_launcher_background).into(Iv_ActivityStar);
        TextView Tv2_ActivityStar = findViewById(R.id.Tv2_ActivityStars);
        Tv2_ActivityStar.setText(star.getSbio());
    }

}
