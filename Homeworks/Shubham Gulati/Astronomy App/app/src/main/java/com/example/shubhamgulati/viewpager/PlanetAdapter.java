package com.example.shubhamgulati.viewpager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {

    private ArrayList<Planet> planetArrayList;
    private Context cxt;

    public PlanetAdapter(ArrayList<Planet> planetArrayList, Context cxt) {
        this.planetArrayList = planetArrayList;
        this.cxt = cxt;
    }

    @NonNull
    @Override
    public PlanetAdapter.PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(cxt);
        View view = li.inflate(R.layout.frag_a_itemrow,parent,false);


        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder holder, int position) {

        final Planet planet = planetArrayList.get(position);
        holder.PlanetTv.setText(planet.getPname());
        Log.e("TAG",""+planet.getPname());
        Picasso.get().load(planet.getPuri()).fit().placeholder(R.drawable.ic_launcher_background).into(holder.ivPlanet);
          holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent i = new Intent(cxt,PlanetActivity.class);
                  i.putExtra("object",planet);
                  cxt.startActivity(i);
              }
          });

    }




    @Override
    public int getItemCount() {
        return planetArrayList.size();
    }

    class PlanetHolder extends RecyclerView.ViewHolder{
    TextView PlanetTv;
    ImageView ivPlanet;
        public PlanetHolder(View itemView) {
            super(itemView);
            PlanetTv = itemView.findViewById(R.id.PlanetTv);
            ivPlanet = itemView.findViewById(R.id.ivPlanet);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //Planet planet = planetArrayList.;
//                    Intent i = new Intent(cxt,PlanetActivity.class);
//                    i.putExtra("object",planet);
//
//                }
//            });
        }
    }
}
