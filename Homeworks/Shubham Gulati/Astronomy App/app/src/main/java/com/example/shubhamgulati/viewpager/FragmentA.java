package com.example.shubhamgulati.viewpager;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {
    ArrayList<Planet> planetsArray = new ArrayList<>();


    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rv = view.findViewById(R.id.rv);
        PlanetAdapter pa = new PlanetAdapter(Planet.getPlanet(),getContext());
        /*rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),PlanetActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("parcel", (Parcelable) planetsArray);
                i.putExtras(bundle);
                startActivity(i);
                // i.putExtra("parcel",new Planet());

            }
        });*/

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(pa);

    }
}
