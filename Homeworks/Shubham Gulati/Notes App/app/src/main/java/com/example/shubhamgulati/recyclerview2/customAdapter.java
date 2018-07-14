package com.example.shubhamgulati.recyclerview2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.ViewHolder>{
    private Context cxt;
    private ArrayList<data> d;

    public customAdapter(Context cxt, ArrayList<data> d) {
        this.cxt = cxt;
        this.d = d;
    }

    @NonNull
    @Override
    public customAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(cxt);

        View inflatedView = li.inflate(R.layout.itemlist,parent,false);
        ViewHolder vh = new ViewHolder(inflatedView);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull final customAdapter.ViewHolder holder, final int position) {
        data n = d.get(position);
        Log.e("TAG2",""+position);
        holder.tv.setText(n.getNote());
        Log.e("tag2",n.getNote());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.i>2){
                    holder.i=0;
                }

                if(holder.i==0){
                    holder.tv.setBackgroundColor(Color.GREEN);
                }else if(holder.i==1){
                    holder.tv.setBackgroundColor(Color.YELLOW);
                } else if(holder.i==2){
                    holder.tv.setBackgroundColor(Color.RED);
                }
                holder.i++;
            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.remove(position);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return d.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        int i;
        Button remove ;
        public ViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            remove = itemView.findViewById(R.id.remove);


        }
    }
}
