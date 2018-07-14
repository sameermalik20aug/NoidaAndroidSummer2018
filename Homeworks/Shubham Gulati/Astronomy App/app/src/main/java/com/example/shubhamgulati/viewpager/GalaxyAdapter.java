package com.example.shubhamgulati.viewpager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalaxyAdapter extends RecyclerView.Adapter<GalaxyAdapter.GalaxyHolder> {
    private ArrayList<Galaxy> galaxyArrayList;
    private Context cxt;

    public GalaxyAdapter(ArrayList<Galaxy> galaxyArrayList, Context cxt) {
        this.galaxyArrayList = galaxyArrayList;
        this.cxt = cxt;
    }

    @NonNull
    @Override
    public GalaxyAdapter.GalaxyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(cxt);
        View view = li.inflate(R.layout.frag_c_itemrow,parent,false);

        return new GalaxyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalaxyAdapter.GalaxyHolder holder, int position) {
        final Galaxy galaxy = galaxyArrayList.get(position);
        holder.GalaxyTv.setText(galaxy.getGname());
        Picasso.get().load(galaxy.getGuri()).fit().placeholder(R.drawable.ic_launcher_background).into(holder.ivGalaxy);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(cxt,GalaxyActivity.class);
                i.putExtra("object",galaxy);
                cxt.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return galaxyArrayList.size();
    }

    public class GalaxyHolder extends RecyclerView.ViewHolder {
        TextView GalaxyTv;
        ImageView ivGalaxy;
        public GalaxyHolder(View itemView) {
            super(itemView);
            GalaxyTv = itemView.findViewById(R.id.GalaxyTv);
            ivGalaxy = itemView.findViewById(R.id.ivGalaxy);
        }
    }
}
