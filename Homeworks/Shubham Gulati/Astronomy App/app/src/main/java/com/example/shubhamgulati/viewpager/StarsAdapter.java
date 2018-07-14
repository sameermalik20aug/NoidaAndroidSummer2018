package com.example.shubhamgulati.viewpager;

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

public class StarsAdapter extends RecyclerView.Adapter<StarsAdapter.Starsholder> {
    private ArrayList<Stars> starsArrayList;
    private Context cxt;

    public StarsAdapter(ArrayList<Stars> starsArrayList, Context cxt) {
        this.starsArrayList = starsArrayList;
        this.cxt = cxt;
    }

    @NonNull
    @Override
    public StarsAdapter.Starsholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(cxt);
        View view = li.inflate(R.layout.frag_b_itemrow,parent,false);
        return new Starsholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarsAdapter.Starsholder holder, int position) {
        final Stars star = starsArrayList.get(position);
        holder.StarsTv.setText(star.getSname());
        Picasso.get().load(star.getSurl()).fit().placeholder(R.drawable.ic_launcher_background).into(holder.ivStars);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(cxt,StarsActivity.class);
                i.putExtra("object",star);
                cxt.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return starsArrayList.size();
    }
    class Starsholder extends RecyclerView.ViewHolder{
    TextView StarsTv;
    ImageView ivStars;
        public Starsholder(View itemView) {
            super(itemView);
            StarsTv = itemView.findViewById(R.id.StarsTv);
            ivStars = itemView.findViewById(R.id.ivStars);
        }
    }
}
