package com.example.shubhamgulati.githubapi;

import android.content.Context;
import android.content.Intent;
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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private ArrayList<Users> usersArrayList;
    private Context cxt;

    public Adapter(ArrayList<Users> usersArrayList, Context cxt) {
        this.usersArrayList = usersArrayList;
        this.cxt = cxt;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(cxt);
       // View view = li.inflate(R.layout.item_row,parent,false);
        View inflatedview = li.inflate(R.layout.row,parent,false);
        ViewHolder viewHolder = new ViewHolder(inflatedview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, final int position) {
        holder.tvRow.setText(usersArrayList.get(position).getLogin());
        Log.e("TAG",usersArrayList.get(position).getLogin());
        Picasso.get()
                .load(usersArrayList.get(position).getAvatar_url())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(cxt,Main2Activity.class);
                i.putExtra("object",usersArrayList.get(position));
                cxt.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRow ;
        ImageView iv;
        public ViewHolder(View itemView) {
            super(itemView);
            tvRow = itemView.findViewById(R.id.tvRow);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
